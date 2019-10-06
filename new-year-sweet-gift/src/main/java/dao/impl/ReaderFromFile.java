package dao.impl;

import dao.api.IReadable;
import model.Candy;
import model.CandyWithFilling;
import model.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderFromFile implements IReadable {

    @Override
    public List<Candy> read() {
        try (FileReader reader = new FileReader(Constants.PATH_TO_INPUT_FILE);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            List<Candy> candies = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(Constants.SEPARATOR);
                if (Constants.CANDY_FIELDS_NUMBER == fields.length) {
                    candies.add(new Candy(fields[0], fields[1], Integer.parseInt(fields[2]),
                            Double.parseDouble(fields[3])));
                } else if (Constants.CANDY_WITH_FILLING_FIELDS_NUMBER == fields.length) {
                    candies.add(new CandyWithFilling(fields[0], fields[1], Integer.parseInt(fields[2]),
                            Double.parseDouble(fields[3]), Arrays.asList(fields[4])));
                }
            }
            return candies;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
