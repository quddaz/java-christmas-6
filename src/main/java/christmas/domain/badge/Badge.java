package christmas.domain.badge;

import java.util.Arrays;

public enum Badge {
    NON(1,4999, "없음"),
    START(5000,9999, "별"),
    TREE(10000,19999, "트리"),
    SANTA(20000, Integer.MAX_VALUE, "산타")
    ;

    private final int price_min;
    private final int price_max;
    private final String name;


    Badge(int priceMin, int priceMax, String name) {
        price_min = priceMin;
        price_max = priceMax;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public static Badge from(int price){
        return Arrays.stream(values())
                .filter(b -> b.price_min <= price && b.price_max >= price)
                .findFirst().orElse(NON);
    }
}
