package entity;

import java.util.Objects;
import java.util.stream.Stream;

public class SimpleAddress {

    private String street;

    private String city;

    public SimpleAddress() {
    }

    public SimpleAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", this.street, this.city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleAddress that = (SimpleAddress) o;
        return Objects.equals(street, that.street) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city);
    }
}
