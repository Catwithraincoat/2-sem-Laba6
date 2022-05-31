package commands;

import java.io.IOException;
import java.io.Serializable;

public class ShowCommand extends Command implements Serializable {
    private static final long serialVersionUID = 63L;
    public ShowCommand(){};
    public void execution(){}
    public String getName() {
        return "show";
    }

}
