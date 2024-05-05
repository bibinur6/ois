public class Product {
    private int idProduct;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(){

    }

    public Product(int idProduct) {
        this.idProduct = idProduct;
    }

    public Product(String name, double price, int quantity,String description){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(int idProduct,String name, double price, int quantity,String description){
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct:" + idProduct +
                ", name:'" + name + '\'' +
                ", price:" + price +
                ", quantity:" + quantity +
                ", description:'" + description + '\'' +
                '}';
    }
}

