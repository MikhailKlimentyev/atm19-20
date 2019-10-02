package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Candy {

    protected String name;
    protected String mainIngredient;
    protected int weight;
    protected double price;

    public Candy(String name, String mainIngredient, int weight, double price) {
        this.name = name;
        this.mainIngredient = mainIngredient;
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public Candy setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Candy setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public Candy setName(String name) {
        this.name = name;
        return this;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public Candy setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        return new EqualsBuilder()
                .append(weight, candy.weight)
                .append(price, candy.price)
                .append(name, candy.name)
                .append(mainIngredient, candy.mainIngredient)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(weight)
                .append(price)
                .append(name)
                .append(mainIngredient)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", mainIngredient='" + mainIngredient + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
