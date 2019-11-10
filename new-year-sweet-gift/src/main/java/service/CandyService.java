package service;

import exception.EmptyFillingException;
import model.Candy;
import model.CandyWithFilling;
import model.Constants;

import java.util.Arrays;

public class CandyService {

    public Candy getRedHat() throws EmptyFillingException {
        return new CandyWithFilling(Constants.RED_HAT_NAME, Constants.CHOCO, Constants.RED_HAT_WEIGHT,
                Constants.RED_HAT_PRICE, Arrays.asList(Constants.WAFFER, Constants.CHOCO));
    }

    public Candy getCrazyBee() {
        return new Candy(Constants.CRAZY_BEE_NAME, Constants.JELLY, Constants.CRAZY_BEE_WEIGHT,
                Constants.CRAZY_BEE_PRICE);
    }

    public Candy getAlenka() throws EmptyFillingException {
        return new CandyWithFilling(Constants.ALENKA_NAME, Constants.CHOCO, Constants.ALENKA_WEIGHT,
                Constants.ALENKA_PRICE, Arrays.asList(Constants.WAFFER, Constants.MILK_CHOCO));
    }

    public Candy getPepperMint() {
        return new Candy(Constants.PEPPER_MINT_NAME, Constants.CARAMEL, Constants.PEPPER_MINT_WEIGHT,
                Constants.PEPPER_MINT_PRICE);
    }

    public Candy getTomboy() {
        return new Candy(Constants.TOMBOY_NAME, Constants.TOFFEY, Constants.TOMBOY_WEIGHT, Constants.TOMBOY_PRICE);
    }

    public Candy getBelochka() throws EmptyFillingException {
        return new CandyWithFilling(Constants.BELOCHKA_NAME, Constants.NUTS, Constants.BELOCHKA_WEIGHT,
                Constants.BELOCHKA_PRICE, Arrays.asList(Constants.NUTS, Constants.CARAMEL));
    }

    public Candy getTruffel() throws EmptyFillingException {
        return new CandyWithFilling(Constants.TRUFFEL_CAPUCCINO_NAME, Constants.CHOCO,
                Constants.TRUFFEL_CAPUCCINO_WEIGHT, Constants.TRUFFEL_CAPUCCINO_PRICE,
                Arrays.asList(Constants.NOUGAT, Constants.MILK_CHOCO, Constants.NUTS));
    }

    public Candy getMetropolitan() throws EmptyFillingException {
        return new CandyWithFilling(Constants.METROPOLITAN_ELIT_NAME, Constants.CHOCO,
                Constants.METROPOLITAN_ELIT_WEIGHT, Constants.METROPOLITAN_ELIT_PRICE,
                Arrays.asList(Constants.ALCOHOL, Constants.DARK_CHOCO));
    }

    public Candy getFortune() {
        return new Candy(Constants.FORTUNE_NAME, Constants.CARAMEL, Constants.FORTUNE_WEIGHT, Constants.FORTUNE_PRICE);
    }
}
