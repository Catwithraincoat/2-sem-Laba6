package commands;


import collection.UnitOfMeasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;


public class RemoveAllByUnitOfMeasure extends Command implements Serializable {
    private static final long serialVersionUID = 599L;
    private String unitOfMeasure;
    public void execution() throws IOException {
        System.out.println("Введите значение поля UnitOfMeasure по котором будет проивзедено удаление элементов");
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String strMeasure = input.readLine().toUpperCase();
            if ((strMeasure.equals("GRAMS")) || (strMeasure.equals("MILLILITERS"))
                    || (strMeasure.equals("SQUARE_METERS"))) {
                this.unitOfMeasure = strMeasure;
            }
            else {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Данные введены не верно, пожалуйста попробуйте еще раз");
        }
    }
    public String getName() {
        return "remove_all_by_unit_of_measure";
    }
}
