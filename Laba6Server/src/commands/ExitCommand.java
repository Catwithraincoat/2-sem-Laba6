package commands;

import collection.CollectionManager;

import java.io.Serializable;

public class ExitCommand extends Command implements Serializable {
    private static final long serialVersionUID = 678L;
    public String execution(CollectionManager collectionManager){
        collectionManager.saveToFile();
        System.exit(0);
        return "Работа окончена, коллекция сохранена";
    }
}
