package org.example.web2.template_table;

public class PriceLine {

    private final Integer id;
    private final String name;
    private final Double price;

    public PriceLine(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
    public Integer getPriceRounded() {
        double d = price;
        return (int) d;
    }
}
