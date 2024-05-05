import java.sql.*;
import java.util.*;

public class ProductJDBC implements ProductDAO {

    private Connection transConnection;

    // Define SQL sentences
    private static final String SQL_SELECT = "SELECT id, name, price, quantity, description FROM product";
    private static final String SQL_SELECT_ONE = "SELECT id, name, price, quantity,description FROM product WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO product(name, price, quantity, description) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE product SET name=?,price=?,quantity=?, description=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM product WHERE id = ?";

    public ProductJDBC(Connection conn){
        this.transConnection = conn;
    }

    public ProductJDBC(){
        super();
    }

   public List<Product> select() throws SQLException{
       Connection conn = null;
       PreparedStatement pStatement = null;
       ResultSet rs = null;
       List<Product> products = new ArrayList<>();

       try {
           conn = this.transConnection !=null?this.transConnection:DBConnection.getConnection();
           pStatement = conn.prepareStatement(SQL_SELECT);
           rs = pStatement.executeQuery();
           while (rs.next()){
               products.add(new Product(
                       rs.getInt("id"),
                       rs.getString("name"),
                       rs.getDouble("price"),
                       rs.getInt("quantity"),
                       rs.getString("description")
               ));
           }
       }catch (SQLException ex){
           System.err.println("Error: "+ex.getMessage());
       }
       finally {
           try {
               if(rs != null)DBConnection.close(rs);
               if(pStatement != null)DBConnection.close(pStatement);
               if(conn != null) {
                   if(this.transConnection == null )DBConnection.close(conn);
               }
           } catch (SQLException throwables) {
               //throwables.printStackTrace();
           }
       }
    return products;
   }

    public Product select(int idProduct) throws SQLException{
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = this.transConnection !=null?this.transConnection:DBConnection.getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT_ONE);
            pStatement.setInt(1,idProduct);
            rs = pStatement.executeQuery();
            while (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("description")
                );
            }


        }catch (SQLException ex){
            System.err.println("Error: "+ex.getMessage());
        }
        finally {
            try {
                if(rs != null)DBConnection.close(rs);
                if(pStatement != null)DBConnection.close(pStatement);
                if(conn != null) {
                    if(this.transConnection == null) DBConnection.close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return product;
    }

    public int insert(Product product) throws SQLException{
       // vaidate name
        if(product.getName() == null) {
            return 0;
        }
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = this.transConnection !=null?this.transConnection:DBConnection.getConnection();
            pStatement = conn.prepareStatement(SQL_INSERT);
            pStatement.setString(1,product.getName());
            pStatement.setDouble(2,product.getprice());
            pStatement.setInt(3,product.getQuantity());
            pStatement.setString(4,product.getDescription());
            result = pStatement.executeUpdate();
            
        }catch (SQLException ex){
            System.err.println("Error: "+ex.getMessage());
        }
        finally {
            try {
                if(pStatement != null)DBConnection.close(pStatement);
                if(conn != null) {
                    if(this.transConnection == null) DBConnection.close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    public int update(Product product) throws SQLException{
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = this.transConnection !=null?this.transConnection:DBConnection.getConnection();
            pStatement = conn.prepareStatement(SQL_UPDATE);
            pStatement.setString(1,product.getName());
            pStatement.setDouble(2,product.getprice());
            pStatement.setInt(3,product.getQuantity());
            pStatement.setString(4,product.getDescription());
            pStatement.setInt(5,product.getIdProduct());
            result = pStatement.executeUpdate();
        }catch (SQLException ex){
            System.err.println("Error: "+ex.getMessage());
        }
        finally {
            try {
                if(pStatement != null)DBConnection.close(pStatement);
                if(conn != null) {
                    if(this.transConnection == null) DBConnection.close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

    public int delete(int idProduct) throws SQLException{
        Connection conn = null;
        PreparedStatement pStatement = null;
        int result = 0;
        try {
            conn = this.transConnection !=null?this.transConnection:DBConnection.getConnection();
            pStatement = conn.prepareStatement(SQL_DELETE);
            pStatement.setInt(1,idProduct);
            result = pStatement.executeUpdate();
        }catch (SQLException ex){
            System.err.println("Error: "+ex.getMessage());
        }
        finally {
            try {
                if(pStatement != null)DBConnection.close(pStatement);
                if(conn != null) {
                    if(this.transConnection == null) DBConnection.close(conn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return result;
    }

}
