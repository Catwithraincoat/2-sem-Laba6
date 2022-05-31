package commands;

import collection.*;
import exceptions.WrongArgsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Objects;

public class AddCommand extends Command implements  Serializable {
    private static final long serialVersionUID = 6L;
    private Product product;

    public AddCommand(){};
    public void execution() {
        product = new ProductCreate().create();
    }

    @Override
    public String getName() {
        return "add";
    }

}