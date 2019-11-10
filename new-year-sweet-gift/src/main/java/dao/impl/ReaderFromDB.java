package dao.impl;

import dao.api.IReadable;
import model.Candy;
import model.CandyWithFilling;
import util.ConnectionDbProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFromDB implements IReadable {

    @Override
    public List<Candy> read() {
        Connection connection = ConnectionDbProvider.getConnection();
        List<Candy> candies = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM main.candies");
            while (resultSet.next()) {
                String filling = resultSet.getString("filling");
                if (filling == null) {
                    Candy candy = new Candy();
                    candy.setName(resultSet.getString("name"));
                    candy.setMainIngredient(resultSet.getString("mainIngredient"));
                    candy.setWeight(resultSet.getInt("weight"));
                    candy.setPrice(resultSet.getDouble("price"));
                    candies.add(candy);
                } else {
                    CandyWithFilling candyWithFilling = new CandyWithFilling();
                    candyWithFilling.setName(resultSet.getString("name"));
                    candyWithFilling.setMainIngredient(resultSet.getString("mainIngredient"));
                    candyWithFilling.setWeight(resultSet.getInt("weight"));
                    candyWithFilling.setPrice(resultSet.getDouble("price"));

                    String[] fillings = resultSet.getString("filling").split(",");
                    List<String> fillingList = Arrays.stream(fillings)
                            .map(String::trim)
                            .collect(Collectors.toList());
                    candyWithFilling.setFilling(fillingList);
                    candies.add(candyWithFilling);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candies;
    }
}
