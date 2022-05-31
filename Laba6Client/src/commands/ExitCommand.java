package commands;

import java.io.Serializable;

public class ExitCommand extends Command implements Serializable {
    private static final long serialVersionUID = 678L;
    public void execution(){
        System.out.println("работа окончена");
        System.exit(0);

    }
    public String getName() {
        return "exit";
    }
}
