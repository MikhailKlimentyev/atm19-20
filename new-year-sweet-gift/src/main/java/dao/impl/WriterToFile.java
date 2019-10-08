package dao.impl;

import dao.api.IWritable;
import model.Candy;
import model.CandyWithFilling;
import model.Constants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class WriterToFile implements IWritable {

    @Override
    public void write(List<? extends Candy> candies) {
        try (FileWriter writer = new FileWriter(Constants.PATH_TO_OUTPUT_FILE);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Candy candy : candies) {
                if (candy.getClass() == Candy.class) {
                    bufferedWriter.write(candy.getName()
                            + Constants.SEPARATOR
                            + candy.getMainIngredient()
                            + Constants.SEPARATOR
                            + candy.getWeight()
                            + Constants.SEPARATOR
                            + candy.getPrice());
                    bufferedWriter.newLine();
                }
                if (candy.getClass() == CandyWithFilling.class) {
                    CandyWithFilling candyWithFilling = (CandyWithFilling) candy;
                    bufferedWriter.write(candyWithFilling.getName()
                            + Constants.SEPARATOR
                            + candyWithFilling.getMainIngredient()
                            + Constants.SEPARATOR
                            + candyWithFilling.getWeight()
                            + Constants.SEPARATOR
                            + candy.getPrice()
                            + Constants.SEPARATOR
                            + candyWithFilling.getFilling());
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
