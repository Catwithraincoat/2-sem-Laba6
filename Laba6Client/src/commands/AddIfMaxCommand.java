package commands;

import collection.Product;
import collection.ProductCreate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class AddIfMaxCommand extends Command implements Serializable {
    private static final long serialVersionUID = 680L;
    private Product product;
    public void execution() throws IOException {
        System.out.println("Введите объект для сравнения с максимальным");
        product = new ProductCreate().create();

    }
    public String getName() {
        return "add_if_max";
    }
}
