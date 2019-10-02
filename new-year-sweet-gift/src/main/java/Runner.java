import model.Candy;
import model.CandyWithFilling;
import service.GiftSevrice;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Candy redHat = new CandyWithFilling("Red Hat", "Choco", 15, 8.55,
                Arrays.asList("Waffer", "Choco"));
        Candy crazyBee = new Candy("Crazy Bee", "Jelly", 10, 7.68);
        Candy alenka = new CandyWithFilling("Alenka", "Choco", 20, 10.20,
                Arrays.asList("Waffer", "Milk Choco"));
        Candy pepperMint = new Candy("Pepper Mint", "Caramel", 8, 4.80);
        Candy tomboy = new Candy("Tomboy", "Toffey", 12, 7.68);
        Candy belochka = new CandyWithFilling("Belochka", "Nuts", 16, 12.45,
                Arrays.asList("Nuts", "Caramel"));
        Candy truffel = new CandyWithFilling("Truffel Capuccino", "Choco", 15, 16.80,
                Arrays.asList("Nougat", "Milk Choco", "Nuts"));
        Candy metropolitan = new CandyWithFilling("Metropolitan Elit", "Choco", 18, 13.20,
                Arrays.asList("Alcohol", "Dark Choco"));
        Candy fortune = new Candy("Fortune", "Caramel", 12, 3.25);

        GiftSevrice giftSevrice = new GiftSevrice();
        List<Candy> gift = giftSevrice.getGift(redHat, crazyBee, alenka, pepperMint, tomboy, belochka, truffel,
                metropolitan, fortune);
        giftSevrice.getGiftWeight(gift);
        giftSevrice.sortGiftByPriceAndByName(gift);
        System.out.println(giftSevrice.getCandiesByMainIngredientAndByMaxPrice(gift, "Choco", 13.10));

    }
}
