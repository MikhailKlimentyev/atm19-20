package service;


import model.Candy;

import java.util.*;

public class GiftSevrice {

    public List<Candy> getGift(Candy... candies) {
        List<Candy> gift = new ArrayList();
        gift.addAll(Arrays.asList(candies));
        return gift;
    }

    public int getGiftWeight(List<Candy> gift) {
        int weight = 0;
        for (Candy candy : gift) {
            weight += candy.getWeight();
        }
        return weight;
    }

    public List<Candy> sortGiftByPriceAndByName(List<Candy> gift) {
        Comparator<Candy> comparatorByPriceAndByName = Comparator.comparing((Candy candy) -> candy.getPrice())
                .thenComparing((Candy candy) -> candy.getName());
        Collections.sort(gift, comparatorByPriceAndByName);
        return gift;
    }

    public List<Candy> getCandiesByMainIngredientAndByMaxPrice(List<Candy> gift, String mainIngredient,
                                                               double maxPrice) {
        List<Candy> resultCandies = new ArrayList<>();
        for (Candy candy : gift) {
            if (mainIngredient.equals(candy.getMainIngredient()) && maxPrice >= candy.getPrice()) {
                resultCandies.add(candy);
            }
        }
        return resultCandies;
    }
}
