package service;

import util.ConnectionDbProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbService {

    public static final String CREATE_MAIN_SCHEMA_QUERY = "CREATE SCHEMA main";
    public static final String CREATE_TABLE_CANDIES_QUERY = "CREATE TABLE main.Candies(\n" +
            "id serial PRIMARY KEY,\n" +
            "name VARCHAR (50),\n" +
            "mainIngredient VARCHAR (50),\n" +
            "weight integer,\n" +
            "price numeric,\n" +
            "filling VARCHAR (100)\n" +
            ");";
    public static final String INSERT_CANDIES_QUERY = "INSERT INTO main.Candies " +
            "(name, mainIngredient, weight, price, filling) VALUES\n" +
            "('Red Hat', 'Choco', 15, '8.55', 'Waffer, Choco'),\n" +
            "('Crazy Bee', 'Jelly', 10, 7.68, null),\n" +
            "('Crazy Bee', 'Jelly', 10, 7.68, null),\n" +
            "('Alenka', 'Choco', 20, 10.20, 'Waffer, Choco'),\n" +
            "('Pepper Mint', 'Caramel', 8, 4.80, null),\n" +
            "('Tomboy', 'Toffey', 12, 7.68, null),\n" +
            "('Belochka', 'Nuts', 16, 12.45, 'Nuts, Caramel'),\n" +
            "('Truffel Capuccino', 'Choco', 15, 16.80, 'Nougat, Milk Choco, Nuts')";

    public int executeQuery(String query) {
        Connection connection = ConnectionDbProvider.getConnection();
        int affectedRows = 0;
        try (Statement statement = connection.createStatement()) {
            affectedRows = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }
}
