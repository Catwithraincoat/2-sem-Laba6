package commands;

import java.io.Serializable;

public class HelpCommand extends Command implements Serializable {
    private static final long serialVersionUID = 67L;
    public HelpCommand(){};
    public void execution(){}
    public String getName() {
        return "help";
    }

}
