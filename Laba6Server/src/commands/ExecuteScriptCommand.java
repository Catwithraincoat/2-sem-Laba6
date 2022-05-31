package commands;

import collection.CollectionManager;
import utils.Message;

import java.io.*;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command implements Serializable {
    private static final long serialVersionUID = 890L;
    private String str = "Выполнение комманд:" + "\n";

    public String execution(CollectionManager collectionManager) throws IOException {
        CommandsKeeper commandsKeeper = new CommandsKeeper(new AddCommand(), new AddIfMaxCommand(), new ExitCommand(), new InfoCommand(), new RemoveAllByUnitOfMeasure(),
                new RemoveByIdCommand(), new RemoveLowerCommand(), new ShowCommand(), new SaveCommand(), new UpdateIdCommand(), new RemoveGreaterCommand());
        //System.out.println("ВВедите полный путь файла");
        File file = new File("test_execution.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            List<String> collection = Arrays.asList(line.split(" "));
            if (collection.get(0).equals("execute_script")) {
                System.out.println("В файле команда execute_script не выполняется");
            } else {
                try {
                    this.str += commandsKeeper.execution(collection.get(0), collectionManager) + "\n";

                } catch (NullPointerException e) {
                    System.out.println("Комманды не считываемы");
                }
            }

        }
        return str.substring(4);
    }
}