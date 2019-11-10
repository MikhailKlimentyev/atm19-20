package model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class Constants {

    public static final String ALENKA_NAME = "Alenka";
    public static final String BELOCHKA_NAME = "Belochka";
    public static final String CRAZY_BEE_NAME = "Crazy Bee";
    public static final String FORTUNE_NAME = "Fortune";
    public static final String METROPOLITAN_ELIT_NAME = "Metropolitan Elit";
    public static final String PEPPER_MINT_NAME = "Pepper Mint";
    public static final String RED_HAT_NAME = "Red Hat";
    public static final String TOMBOY_NAME = "Tomboy";
    public static final String TRUFFEL_CAPUCCINO_NAME = "Truffel Capuccino";

    public static final String ALCOHOL = "Alcohol";
    public static final String CARAMEL = "Caramel";
    public static final String CHOCO = "Choco";
    public static final String DARK_CHOCO = "Dark Choco";
    public static final String JELLY = "Jelly";
    public static final String MILK_CHOCO = "Milk Choco";
    public static final String NOUGAT = "Nougat";
    public static final String NUTS = "Nuts";
    public static final String TOFFEY = "Toffey";
    public static final String WAFFER = "Waffer";

    public static final int ALENKA_WEIGHT = 20;
    public static final int BELOCHKA_WEIGHT = 16;
    public static final int CRAZY_BEE_WEIGHT = 10;
    public static final int FORTUNE_WEIGHT = 12;
    public static final int METROPOLITAN_ELIT_WEIGHT = 18;
    public static final int PEPPER_MINT_WEIGHT = 8;
    public static final int RED_HAT_WEIGHT = 15;
    public static final int TOMBOY_WEIGHT = 12;
    public static final int TRUFFEL_CAPUCCINO_WEIGHT = 15;

    public static final double ALENKA_PRICE = 10.20;
    public static final double BELOCHKA_PRICE = 12.45;
    public static final double CRAZY_BEE_PRICE = 7.68;
    public static final double FORTUNE_PRICE = 3.25;
    public static final double METROPOLITAN_ELIT_PRICE = 13.20;
    public static final double PEPPER_MINT_PRICE = 4.80;
    public static final double RED_HAT_PRICE = 8.55;
    public static final double TOMBOY_PRICE = 7.68;
    public static final double TRUFFEL_CAPUCCINO_PRICE = 16.80;

    public static final int CANDY_FIELDS_NUMBER = 4;
    public static final int CANDY_WITH_FILLING_FIELDS_NUMBER = 5;

    public static final String INPUT_FILE_NAME = "in.txt";
    public static final String INPUT_JSON = "Candies.json";
    public static final String INPUT_XML = "Candies.xml";
    public static final String OUTPUT_FILE_NAME = "out.txt";
    public static final String DATABASE_PROPERTIES = "database.properties";

    public static final String PATH_TO_FILE = String.format("new-year-sweet-gift%ssrc%smain%sresources%s",
            File.separator, File.separator, File.separator, File.separator);
    public static final String PATH_TO_INPUT_FILE = PATH_TO_FILE + Constants.INPUT_FILE_NAME;
    public static final String PATH_TO_INPUT_JSON = PATH_TO_FILE + Constants.INPUT_JSON;
    public static final String PATH_TO_INPUT_XML = PATH_TO_FILE + Constants.INPUT_XML;
    public static final String PATH_TO_OUTPUT_FILE = PATH_TO_FILE + Constants.OUTPUT_FILE_NAME;
    public static final String DATABASE_PROPERTIES_FILE = PATH_TO_FILE + Constants.DATABASE_PROPERTIES;

    public static final String GIFT_CREATED_MESSAGE = "Gift have been got successfully";

    public static final String SEPARATOR = ";";

    public static final Map<Integer, String> NUMBER_INGREDIENT_MAP = new HashMap<>();

    private Constants() {
        throw new AssertionError("This class should never be instantiated.");
    }

    static {
        NUMBER_INGREDIENT_MAP.put(1, ALCOHOL);
        NUMBER_INGREDIENT_MAP.put(2, CARAMEL);
        NUMBER_INGREDIENT_MAP.put(3, CHOCO);
        NUMBER_INGREDIENT_MAP.put(4, DARK_CHOCO);
        NUMBER_INGREDIENT_MAP.put(5, JELLY);
        NUMBER_INGREDIENT_MAP.put(6, MILK_CHOCO);
        NUMBER_INGREDIENT_MAP.put(7, NOUGAT);
        NUMBER_INGREDIENT_MAP.put(8, NUTS);
        NUMBER_INGREDIENT_MAP.put(9, TOFFEY);
        NUMBER_INGREDIENT_MAP.put(10, WAFFER);
    }
}
