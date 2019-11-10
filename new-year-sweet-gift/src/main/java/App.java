import dao.api.IReadable;
import dao.api.IWritable;
import dao.impl.*;
import model.Candy;
import model.Constants;
import model.Gift;
import service.CandyService;
import service.GiftService;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
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

        GiftService giftService = new GiftService();
        Gift gift = giftService.getGift(redHat, crazyBee, alenka, pepperMint, tomboy, belochka, truffel, metropolitan,
                fortune);
        System.out.println(giftService.getGiftWeight(gift));
        System.out.println(giftService.sortGiftByPriceAndByName(gift).getCandies());
        System.out.println(giftService.getCandiesByMainIngredientAndByMaxPrice(gift, Constants.CHOCO, 13.10));

        IWritable writer = new WriterToFile();
        writer.write(Arrays.asList(redHat, crazyBee, alenka, pepperMint, tomboy, belochka, truffel, metropolitan,
                fortune));

        IReadable reader = new ReaderFromFile();
        System.out.println(reader.read());

        ReaderFromJSON readerFromJSON = new ReaderFromJSON();
        System.out.println(readerFromJSON.read());

        ReaderFromXmlDOM readerFromXmlDOM = new ReaderFromXmlDOM();
        System.out.println(readerFromXmlDOM.read());

        ReaderFromDB readerFromDB = new ReaderFromDB();
        System.out.println(readerFromDB.read());
    }
}

