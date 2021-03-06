package model;

import exception.EmptyFillingException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;


public class CandyWithFilling extends Candy {

    private List<String> filling;

    public CandyWithFilling() {
    }

    public CandyWithFilling(String name, String mainIngredient, int weight, double price, List<String> filling)
            throws EmptyFillingException {
        super(name, mainIngredient, weight, price);
        if (filling == null || filling.size() == 0) {
            throw new EmptyFillingException("Candy with filling cannot be without filling");
        }
        this.filling = filling;
        this.filling = filling;
    }

    public List<String> getFilling() {
        return filling;
    }

    public CandyWithFilling setFilling(List<String> filling) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CandyWithFilling that = (CandyWithFilling) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(filling, that.filling)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(filling)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CandyWithFilling{" +
                "filling=" + filling +
                ", name='" + name + '\'' +
                ", mainIngredient='" + mainIngredient + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
