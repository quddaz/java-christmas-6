package christmas.domain.menu;

import christmas.exception.CustomException;
import christmas.exception.ExceptionMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public enum Menu {
    양송이수프(6000, Category.APPETIZER),
    타파스(5500, Category.APPETIZER),
    시저샐러드(8000, Category.APPETIZER),
    티본스테이크(55000, Category.MAIN),
    바비큐립(54000, Category.MAIN),
    해산물파스타(35000, Category.MAIN),
    크리스마스파스타(25000, Category.MAIN),
    초코케이크(15000,Category.DESSERT),
    아이스크림(5000,Category.DESSERT),

    제로콜라(3000,Category.DRINK),
    레드와인(60000, Category.DRINK),
    샴페인(25000, Category.DRINK);



    private final int price;
    private final Category category;

    Menu(int price, Category category) {
        this.price = price;
        this.category = category;
    }

    public int getPrice(){
        return price;
    }

    public Category getCategory(){
        return category;
    }
    public static Menu from(String name){
        return Arrays.stream(values())
                .filter(m -> m.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new CustomException(ExceptionMessage.INVALID_ORDER));
    }

    public static void containsNonDrink(Map<Menu, Integer> menus){
        int count = (int) menus.keySet().stream()
                .filter(m -> m.category != Category.DRINK)
                .count();
        if(count == 0)
            throw  new CustomException(ExceptionMessage.INVALID_ORDER);
    }

    public static void validateDuplicate(Map<Menu, Integer> menus){
        if(menus.size() != Set.copyOf(menus.keySet()).size())
            throw  new CustomException(ExceptionMessage.INVALID_ORDER);
    }
}
