package commands;

import collection.Product;
import collection.ProductCreate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class UpdateIdCommand extends Command implements Serializable {
    private static final long serialVersionUID = 600L;
    private Product product;
    public void execution() throws IOException {
        System.out.println("Введите значение id которое хотите обновить");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String id = input.readLine();
        product = new ProductCreate().create();
        product.setId2(Long.parseLong(id));
    }
    public String getName() {
        return "update_id";
    }
}
