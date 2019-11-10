package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Gift {

    private List<Candy> candies;

    public Gift() {
    }

    public Gift(List<Candy> candies) {
        this.candies = new ArrayList<>(candies);
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public Gift setCandies(List<Candy> candies) {
        this.candies = candies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Gift gift = (Gift) o;

        return new EqualsBuilder()
                .append(candies, gift.candies)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(candies)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gift{");
        sb.append("candies=").append(candies);
        sb.append('}');
        return sb.toString();
    }
}
