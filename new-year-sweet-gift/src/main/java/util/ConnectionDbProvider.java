package util;

import model.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class ConnectionDbProvider {

    private static ConnectionDbProvider instance;
    private static Connection conn;

    /**
     * This class never should be instantiated.
     */
    private ConnectionDbProvider() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            Properties props = new Properties();
            try (InputStream in = Files.newInputStream(Paths.get(Constants.DATABASE_PROPERTIES_FILE))) {
                props.load(in);
            } catch (IOException e) {
                System.err.println(String.format("Cannot access database.properties file...%n %s", e));
            }
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            conn = DriverManager.getConnection(url, username, password);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | NoSuchMethodException | ClassNotFoundException e) {
            System.err.println(String.format("Getting driver instance is failed...%n %s", e));
        } catch (SQLException sqle) {
            System.err.println(String.format("Connection is failed...%n %s", sqle));
        }
    }

    public static Connection getConnection() {
        if (instance == null) {
            instance = new ConnectionDbProvider();
        }
        return instance.getConn();
    }

    private static Connection getConn() {
        return conn;
    }
}
