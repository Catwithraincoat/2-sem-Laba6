package commands;


import java.io.IOException;

public abstract class Command {
    public void  execution() throws IOException {
    }


    String getName() {
        return null;
    }
}