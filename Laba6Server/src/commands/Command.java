package commands;

import collection.CollectionManager;

import java.io.IOException;

public abstract class Command {
    public String execution(CollectionManager collectionManager) throws IOException {
        return null;
    }


    String getName() {
        return null;
    }
}

