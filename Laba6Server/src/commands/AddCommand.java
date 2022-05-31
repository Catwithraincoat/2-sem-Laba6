package commands;

import collection.*;

import java.io.IOException;

import java.io.Serializable;


public class AddCommand extends Command implements Serializable {
    private static final long serialVersionUID = 6L;
    private Product product;
    @Override
    public String execution(CollectionManager collectionManager) throws IOException {
        collectionManager.add(product);
        System.out.println(collectionManager.getAllElements());
        return "Объект добавлен";

    }

    @Override
    public String getName() {return "add";}



    public String getDescription() {return "add: добавить новый элемент в коллекцию";}
}

