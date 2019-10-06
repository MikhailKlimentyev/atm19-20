package dao.impl;

import dao.api.IWritable;
import model.Candy;
import model.Constants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class WriterToFile implements IWritable {

    @Override
    public void write(List<Candy> candies) {
        try (FileWriter writer = new FileWriter(Constants.PATH_TO_OUTPUT_FILE);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Candy candy : candies) {
                bufferedWriter.write(candy.getName() + Constants.SEPARATOR + candy.getMainIngredient()
                        + Constants.SEPARATOR + candy.getWeight() + Constants.SEPARATOR + candy.getPrice());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
