package controller;

public class Product {
    private String name;
    private String sku;
    private int quantity;
    private double price;

    /**
     * @param name     The product name.
     * @param sku      The SKU number for the product.
     * @param quantity The amount of product.
     * @param price    The price of the product.
     */

    public Product(String name, String sku, int quantity, double price) {
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        String res = "";
        res = this.name;
        return res;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }


}
