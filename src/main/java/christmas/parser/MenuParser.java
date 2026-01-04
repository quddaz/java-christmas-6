package christmas.parser;

import christmas.domain.menu.Menu;
import christmas.exception.CustomException;
import christmas.exception.ExceptionMessage;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuParser {
    private MenuParser(){}

    public static Map<Menu, Integer> parse(String input){
        String[] arr = input.replace(" ", "").split(",");
        Map<Menu, Integer> menus = new LinkedHashMap<>();
        for(String in : arr){
            String[] orderInfo = in.split("-");
            validateLength(orderInfo);
            Menu menu = Menu.from(orderInfo[0]);
            int count = validateIntFormat(orderInfo[1]);

            containsMap(menus, menu);
            menus.put(menu, count);
        }

        validateMenuCount(menus);

        return menus;
    }
    private static void containsMap(Map<Menu, Integer> menus, Menu menu){
        if(menus.containsKey(menu))
            throw new CustomException(ExceptionMessage.INVALID_ORDER);
    }

    private static void validateLength(String[] orderInfo){
        if(orderInfo.length != 2)
            throw new CustomException(ExceptionMessage.INVALID_ORDER);
    }
    private static int validateIntFormat(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new CustomException(ExceptionMessage.INVALID_ORDER);
        }
    }

    private static void validateMenuCount(Map<Menu, Integer> menus) {
        int count = menus.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (count > 20) {
            throw new CustomException(ExceptionMessage.INVALID_ORDER);
        }
    }
}
