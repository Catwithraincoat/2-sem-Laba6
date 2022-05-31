package commands;

import java.io.IOException;
import java.io.Serializable;

public class ExecuteScriptCommand extends Command implements Serializable {
    private static final long serialVersionUID = 890L;

    @Override
    public void execution() throws IOException {
        System.out.println("Далее будет выведено выполнение комманд");
    }
    public String getName() {
        return "execute_script";
    }
}
