package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * @author Brian
 */
public class DatabaseManager {

    /**
     * @param name returns the product found with the name supplied
     */
    public static ArrayList<Product> searchByName(String name) {
        ArrayList<Product> products = getProducts();
        ArrayList<Product> matches = new ArrayList<>();
        if (products.size() > 0) {
            for (Product p : products) {
                if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                    matches.add(p);
                }
            }
        }
        return matches;
    }

    /**
     * @param sku returns the product whose SKU is equal to the number passed to this function
     */
    public static ArrayList<Product> searchBySku(String sku) {
        ArrayList<Product> products = getProducts();
        ArrayList<Product> matches = new ArrayList<>();
        if (products.size() > 0) {
            for (Product p : products) {
                if (p.getSku().equals(sku)) {
                    matches.add(p);
                }
            }
        }
        return matches;
    }

    /**
     * @param price
     * @return returns the product whose price is equal to the double passed to this function
     */
    public static ArrayList<Product> searchByPrice(double price) {
        ArrayList<Product> products = getProducts();
        ArrayList<Product> matches = new ArrayList<>();
        if (products.size() > 0) {
            for (Product p : products) {
                if (p.getPrice() == price) {
                    matches.add(p);
                }
            }
        }
        return matches;
    }

    /**
     * @return returns An <code>ArrayList</code> of products read from <code>"products.txt"</code>
     */
    public static ArrayList<Product> getProducts() {
        File f = new File("src/model/products.txt");
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(f))) {
            String line = in.readLine();
            while (line != null) {
                String[] prodAttributes = line.split("\t");
                String name = prodAttributes[0];
                String sku = prodAttributes[1];
                int qty = Integer.parseInt(prodAttributes[2]);
                double price = Double.parseDouble(prodAttributes[3]);
                Product p = new Product(name, sku, qty, price);
                products.add(p);
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return products;
    }

    /**
     * @param products saves an ArrayList of products to "products.txt", overriding what currently exists
     */
    public static void saveProducts(ArrayList<Product> products) {
        File f = new File("src/model/products.txt");
        try (PrintWriter p = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(f)))) {
            for (Product prod : products) {
                p.print(prod.getName() + "\t");
                p.print(prod.getSku() + "\t");
                p.print(prod.getQuantity() + "\t");
                p.print(prod.getPrice() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
