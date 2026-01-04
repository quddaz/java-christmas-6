package christmas.domain;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> purchases;

    public Order(Map<Menu, Integer> purchase){
        validate(purchase);
        this.purchases = Map.copyOf(purchase);
    }

    private void validate(Map<Menu, Integer> purchase){
        Menu.containsNonDrink(purchase);
        Menu.validateDuplicate(purchase);
    }


    public int getTotalMoney(){
        return purchases.entrySet().stream()
                .mapToInt(m -> m.getKey().getPrice() * m.getValue())
                .sum();
    }

    public Map<Menu, Integer> getPrintMenu(){
        return Map.copyOf(purchases);
    }

    public int getDessertCount(){
        return (int)purchases.entrySet().stream()
                .filter(e -> e.getKey().getCategory() == Category.DESSERT)
                .count();
    }

    public int getMainCount(){
        return (int)purchases.entrySet().stream()
                .filter(e -> e.getKey().getCategory() == Category.MAIN)
                .count();
    }
}
