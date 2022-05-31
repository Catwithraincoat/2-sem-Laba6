package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class AddIfMaxCommand extends Command implements Serializable {
    private static final long serialVersionUID = 680L;
    private Product product;
    private Double Max ;
    public String execution(CollectionManager collectionManager){
        HashSet<Product> goods = collectionManager.getAllElements();
        Iterator<Product> it = goods.iterator();
        while (it.hasNext()) {
            if (it.next().getPrice() > product.getPrice()){return "Цена объекта меньше " + it.next().getPrice();}
        }
        collectionManager.add(product);
        return "Объект добавлен ";
    }

}
