import dao.api.IReadable;
import dao.api.IWritable;
import dao.impl.*;
import exception.EmptyFillingException;
import exception.MenuNumberInputException;
import model.Candy;
import model.Constants;
import model.Gift;
import service.CandyService;
import service.GiftService;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static boolean condition = true;

    public static void main(String[] args) throws EmptyFillingException {
        while (condition) {
            System.out.println("Please select gift data source:\n" +
                    "1. Program\n" +
                    "2. File\n" +
                    "3. JSON\n" +
                    "4. XML\n" +
                    "5. Database\n" +
                    "0. Exit");
            Scanner menuInput = new Scanner(System.in);
            GiftService giftService = new GiftService();
            Gift gift = new Gift();
            try {
                int menuNumber = Integer.parseInt(menuInput.nextLine());
                gift = getGift(menuNumber, giftService, gift);
            } catch (MenuNumberInputException mnie) {
                System.err.println(mnie.getMessage());
                continue;
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid input. Please enter number from menu");
                continue;
            }
            if (!condition) {
                System.out.println("Exit...");
                break;
            }
            while (condition) {
                System.out.println("Please select action:\n" +
                        "1. Get gift weight\n" +
                        "2. Sort gift by price and name\n" +
                        "3. Get candies by main ingredient and by max price\n" +
                        "4. Write candies to file\n" +
                        "0. Exit");
                Scanner actionInput = new Scanner(System.in);
                try {
                    int actionNumber = Integer.parseInt(actionInput.nextLine());
                    makeActionOnGift(giftService, gift, actionNumber);
                } catch (MenuNumberInputException mnie) {
                    System.err.println(mnie.getMessage());
                    continue;
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid input. Please enter number from menu");
                    continue;
                }
                if (!condition) {
                    System.out.println("Exit...");
                    break;
                }
            }
        }
    }

    private static Gift getGift(int menuNumber, GiftService giftService, Gift gift) throws MenuNumberInputException,
            EmptyFillingException {
        switch (menuNumber) {
            case 1:
                CandyService candyService = new CandyService();
                Candy redHat = candyService.getRedHat();
                Candy crazyBee = candyService.getCrazyBee();
                Candy alenka = candyService.getAlenka();
                Candy pepperMint = candyService.getPepperMint();
                Candy tomboy = candyService.getTomboy();
                Candy belochka = candyService.getBelochka();
                Candy truffel = candyService.getTruffel();
                Candy metropolitan = candyService.getMetropolitan();
                Candy fortune = candyService.getFortune();
                gift = giftService.getGift(Arrays.asList(redHat, crazyBee, alenka, pepperMint, tomboy, belochka,
                        truffel, metropolitan, fortune));
                System.out.println(Constants.GIFT_CREATED_MESSAGE);
                break;
            case 2:
                IReadable reader = new ReaderFromFile();
                gift = giftService.getGift(reader.read());
                System.out.println(Constants.GIFT_CREATED_MESSAGE);
                break;
            case 3:
                ReaderFromJSON readerFromJSON = new ReaderFromJSON();
                gift = giftService.getGift(readerFromJSON.read());
                System.out.println(Constants.GIFT_CREATED_MESSAGE);
                break;
            case 4:
                ReaderFromXmlDOM readerFromXmlDOM = new ReaderFromXmlDOM();
                gift = giftService.getGift(readerFromXmlDOM.read());
                System.out.println(Constants.GIFT_CREATED_MESSAGE);
                break;
            case 5:
                ReaderFromDB readerFromDB = new ReaderFromDB();
                gift = giftService.getGift(readerFromDB.read());
                System.out.println(Constants.GIFT_CREATED_MESSAGE);
                break;
            case 0:
                condition = false;
                break;
            default:
                throw new MenuNumberInputException("Invalid number");
        }
        return gift;
    }

    private static void makeActionOnGift(GiftService giftService, Gift gift, int actionNumber)
            throws MenuNumberInputException {
        switch (actionNumber) {
            case 1:
                System.out.println(String.format("Gift weight: %s", giftService.getGiftWeight(gift)));
                break;
            case 2:
                System.out.println(String.format("Sorted by price and by name gift : %s",
                        giftService.sortGiftByPriceAndByName(gift).getCandies()));
                break;
            case 3:
                getCandiesByParameters(giftService, gift);
            case 4:
                IWritable writer = new WriterToFile();
                writer.write(gift.getCandies());
                System.out.println("Candies have been written to file successfully");
                break;
            case 0:
                condition = false;
                break;
            default:
                throw new MenuNumberInputException("Invalid number");
        }
    }

    private static void getCandiesByParameters(GiftService giftService, Gift gift) {
        while (true) {
            System.out.println("Please select ingredient:\n" +
                    "1. Alcohol\n" +
                    "2. Caramel\n" +
                    "3. Choco\n" +
                    "4. Dark Choco\n" +
                    "5. Jelly\n" +
                    "6. Milk Choco\n" +
                    "7. Nougat\n" +
                    "8. Nuts\n" +
                    "9. Toffey\n" +
                    "10. Waffer");
            Scanner ingredientInput = new Scanner(System.in);
            try {
                int ingredientNumber = Integer.parseInt(ingredientInput.nextLine());
                String mainIngredient = Constants.NUMBER_INGREDIENT_MAP.get(ingredientNumber);
                if (mainIngredient == null) {
                    System.err.println("Invalid number");
                    continue;
                }
                while (true) {
                    try {
                        System.out.println("Please input max price:");
                        Scanner maxPriceInput = new Scanner(System.in);
                        double maxPriceNumber = maxPriceInput.nextDouble();
                        System.out.println(String.format("Candies found by main ingredient and max price: %s",
                                giftService.getCandiesByMainIngredientAndByMaxPrice(gift, mainIngredient,
                                        maxPriceNumber)));
                    } catch (InputMismatchException ime) {
                        System.err.println("Invalid input. Please enter double");
                        continue;
                    }
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid input. Please enter number from menu");
                continue;
            }
            break;
        }
    }
}

