package commands;

import collection.CollectionManager;
import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

    public class CommandsKeeper {
        private static HashMap<String, Command> session_commands = new HashMap<>();
        public CommandsKeeper(Command... coms){
            for (Command i : coms){
                session_commands.put(i.getName(), i);
            }
        }
        public String execution(String coms, CollectionManager collectionManager) throws IOException {
            System.setOut(System.out);
            String str = session_commands.get(coms).execution(collectionManager);
            return str;
        }
    }

