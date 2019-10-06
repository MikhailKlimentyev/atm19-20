package service;


import model.Candy;
import model.Gift;

import java.util.*;

public class GiftService {

    public Gift getGift(Candy... candies) {
        return new Gift(Arrays.asList(candies));
    }

    public int getGiftWeight(Gift gift) {
        int weight = 0;
        for (Candy candy : gift.getCandies()) {
            weight += candy.getWeight();
        }
        return weight;
    }

    public Gift sortGiftByPriceAndByName(Gift gift) {
        Comparator<Candy> comparatorByPriceAndByName = Comparator.comparing((Candy candy) -> candy.getPrice())
                .thenComparing(candy -> candy.getName());
        Collections.sort(gift.getCandies(), comparatorByPriceAndByName);
        return gift;
    }

    public List<Candy> getCandiesByMainIngredientAndByMaxPrice(Gift gift, String mainIngredient, double maxPrice) {
        List<Candy> resultCandies = new ArrayList<>();
        for (Candy candy : gift.getCandies()) {
            if (mainIngredient.equals(candy.getMainIngredient()) && maxPrice >= candy.getPrice()) {
                resultCandies.add(candy);
            }
        }
        return resultCandies;
    }
}
