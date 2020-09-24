package entities;

import enums.Currency;

public class Payment {
    private String name;
    private Long cost;
    private Currency currency;

    public Payment() {
    }

    public Payment(String name, Long cost, Currency currency) {
        this.name = name;
        this.cost = cost;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", currency=" + currency +
                '}';
    }
}
