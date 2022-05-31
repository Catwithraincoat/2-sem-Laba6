package commands;

import java.io.Serializable;

public class PrintFieldDescendingmanufacturerCommand extends Command implements Serializable {
    private static final long serialVersionUID = 489L;

    public PrintFieldDescendingmanufacturerCommand() {}
    public void execution(){}
    public String getName() {
        return "print_field_descending_manufacturer";
    }
}
