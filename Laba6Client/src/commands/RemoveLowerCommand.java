package commands;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;


public class RemoveLowerCommand extends Command implements Serializable {
    private static final long serialVersionUID = 37L;
    private Double price;

    @Override
    public void execution() throws IOException {
        System.out.println("Введите цену меньше, которой нужно удалить товары");
        try {
            while (true) {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String price = input.readLine();
                if (Double.valueOf(price) <= 0){
                    throw new NumberFormatException(); }
                this.price = Double.valueOf(price);
                break;
            }
        }catch(NumberFormatException e){
            System.out.println("Данные введены неверно попробуйте еще раз");
        }

    }
    public String getName() {
        return "remove_lower";
    }
}