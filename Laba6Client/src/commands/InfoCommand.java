package commands;

import java.io.Serializable;

public class InfoCommand extends Command implements Serializable {
    private static final long serialVersionUID = 47L;
    public InfoCommand(){};
    public void execution(){}
    public String getName() {
        return "info";
    }
}
