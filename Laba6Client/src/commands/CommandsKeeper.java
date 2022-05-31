package commands;


import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class CommandsKeeper {
    private static HashMap<String, Command> session_commands = new HashMap<>();
    private static Command command;
    public CommandsKeeper(Command... coms){
        for (Command i : coms){
            session_commands.put(i.getName(), i);
        }
    }
    public static Command execution(String coms) throws IOException {
        System.setOut(System.out);

        command = session_commands.get(coms);
        command.execution();
        return command;
    }
}

