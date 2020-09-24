import entities.Payment;
import entities.Transaction;
import enums.Category;
import enums.Currency;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static enums.Category.ONE;
import static enums.Category.TWO;
import static enums.Currency.EU;
import static enums.Currency.RUB;

public class Test {
    public static void main(String[] args) {

        List<Transaction> transactions = Test.getTransactions();
        
    }

    public static Optional<Category> getCoolestCategoryBySumOfCoasts(List<Transaction> transactions, Currency currency){
        Optional<Category> bestCategory = Stream.of(Category.values())
                .max(Comparator.comparing(category -> getSumOfCoastsWithExactCategoryAndCurrency(transactions, category, currency)));

        return bestCategory;
    }

    public static Long getSumOfCoastsWithExactCategoryAndCurrency(List<Transaction> transactions,
                                                                  Category category,
                                                                  Currency currency){
        Long sum = transactions.stream()
                .filter(transaction -> transaction.getCategory() == category)
                .flatMap(transaction -> transaction.getPayments().stream())
                .filter(payment -> payment.getCurrency() == currency)
                .map(payment -> payment.getCost())
                .reduce(Long::sum).orElseGet(() -> 0L);

        return sum;
    }

    public static Optional<Category> getCoolestCategoryByCountOfPayments(List<Transaction> transactions){
        Optional<Category> bestCategory = Stream.of(Category.values())
                .max(Comparator.comparing(category -> getCountOfPaymentsWithExactCategory(transactions,category)));

        return bestCategory;
    }

    public static Long getCountOfPaymentsWithExactCategory(List<Transaction> transactions, Category category){
        Long count = transactions
                .stream()
                .filter(transaction -> transaction.getCategory() == category)
                .flatMap(transaction -> transaction.getPayments().stream())
                .count();

        return count;
    }


    public static List<Transaction> getTransactions(){
        Transaction t1 = new Transaction(1L, ONE, List.of(
                new Payment("house", 11000L, EU),
                new Payment("car", 1100L, EU),
                new Payment("business", 10000000L, RUB),
                new Payment("phone", 1000L, RUB)
        ));
        Transaction t2 = new Transaction(2L, ONE, List.of(
                new Payment("house", 20000L, EU),
                new Payment("car", 2000L, EU),
                new Payment("business", 20000L, RUB),
                new Payment("phone", 2000L, RUB)
        ));
        Transaction t3 = new Transaction(3L, ONE, List.of(
                new Payment("house", 3000000000000L, EU),
                new Payment("car", 3000L, EU),
                new Payment("business", 3000000000000L, RUB),
                new Payment("phone", 3000L, RUB)
        ));
        Transaction t4 = new Transaction(4L, TWO, List.of(
                new Payment("house", 4000000000000000L, EU),
                new Payment("car", 4000L, EU),
                new Payment("business", 40000L, RUB),
                new Payment("phone", 4000L, RUB)
        ));
        Transaction t5 = new Transaction(5L,TWO, List.of(
                new Payment("house", 500000000L, EU),
                new Payment("car", 5000L, EU),
                new Payment("business", 5000000000000L, RUB),
                new Payment("phone", 5000L, RUB)
        ));

        return List.of(t1, t2, t3, t4, t5);
    }
}
