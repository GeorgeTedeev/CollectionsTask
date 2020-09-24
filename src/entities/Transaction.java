package entities;

import enums.Category;

import java.util.List;

public class Transaction {
    private Long id;
    private Category category;
    private List<Payment> payments;

    public Transaction() {
    }

    public Transaction(Long id, Category category, List<Payment> payments) {
        this.id = id;
        this.category = category;
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", category=" + category +
                ", payments=" + payments +
                '}';
    }
}
