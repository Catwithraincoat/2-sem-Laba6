package commands;

import collection.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveByIdCommand extends Command implements Serializable {
    private static final long serialVersionUID = 589L;
    private Long Id;
    public void  execution() throws IOException {
        while (true) {
            try {
                System.out.println("Введите номер id");
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String id = input.readLine();
                if (Long.valueOf(id) <= 0){
                    throw new NumberFormatException(); }
                this.Id = Long.valueOf(id);

                break;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число попрбуйте еще раз");
            }
        }
    }
    public String getName() {
        return "remove_by_id";
    }

}
