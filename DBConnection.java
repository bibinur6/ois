import java.sql.*;

public class DBConnection {
    private static String connectionString = "jdbc:postgresql://localhost:5432/ois";
    private static String user = "admin";
    private static String password = "12345678";
    private static String host = "localhost";
    private static int port = 5432;
    private static String database ="ois";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connectionString, user, password);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement statement) throws SQLException {
        statement.close();
    }

    public static void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    public static void close(Connection cnn) throws SQLException {
        cnn.close();
    }

    public static void setDatabaseUser(String userdb) {
        user = userdb;
    }

    public static void setDatabasePassword(String passwd) {
        password = passwd;
    }

    public static void reloadStringConnection() {
        connectionString = "jdbc:postgresql://" + host + ":" + port + "/" + database;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DBConnection.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        DBConnection.port = port;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        DBConnection.database = database;
    }

    public static String getConnectionString() {
        return connectionString;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

}
