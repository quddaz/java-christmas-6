package christmas.view;

import christmas.domain.badge.Badge;
import christmas.domain.menu.Menu;
import christmas.dto.BonusMenu;
import christmas.dto.EventResult;
import java.util.Map;

public class OutputView {
    private OutputView(){}

    public static void printExceptionMessage(String e){
        System.out.println(e);
    }

    public static void printStart(){
        System.out.println(OutputConfig.START_MESSAGE.get());
    }
    public static void printDateInput(){
        System.out.println(OutputConfig.DATE_INPUT_MESSAGE.get());
    }
    public static void printOrderInput(){
        System.out.println(OutputConfig.ORDER_INPUT_MESSAGE.get());
    }
    public static void printInfo(int day){
        System.out.printf(OutputConfig.INFO_MESSAGE.get(), day);
    }

    public static void printMenu(Map<Menu, Integer> menus){
        System.out.println(OutputConfig.MENU_MESSAGE.get());
        menus.entrySet().stream()
                .forEach(m -> System.out.printf(OutputConfig.MENU_INFO_MESSAGE.get()
                ,m.getKey().name(), m.getValue()));
    }

    public static void printNonDiscount(int price){
        System.out.println(OutputConfig.NON_DISCOUNT_INFO_MESSAGE.get());
        System.out.printf(OutputConfig.NON_DISCOUNT_MONEY_MESSAGE.get(), price);
    }

    public static void printEventInfo(EventResult eventResult){
        System.out.println(OutputConfig.EVENT_MESSAGE.get());

        if (eventResult.result().isEmpty()) {
            System.out.println("없음");
            return;
        }

        System.out.println(eventResult.result());
    }

    public static void printDiscountMoney(int price){
        System.out.println(OutputConfig.DISCOUNT_AFTER_MESSAGE.get());
        System.out.printf(OutputConfig.TOTAL_EVENT_MONEY_MESSAGE.get(),price);
    }

    public static void printBonusMenu(BonusMenu bonusMenu){
        System.out.println(OutputConfig.BONUS_MENU_MESSAGE.get());
        if (bonusMenu.count() == 0) {
            System.out.println(OutputConfig.NON_BONUS_MESSAGE.get());
            return;
        }

        System.out.printf(OutputConfig.BONUS_MESSAGE.get(), bonusMenu.name(), bonusMenu.count());
    }

    public static void printTotalMoney(EventResult eventResult){
        System.out.println(OutputConfig.MONEY_MESSAGE.get());
        System.out.printf(OutputConfig.TOTAL_MONEY_MESSAGE.get(),eventResult.total_money() - eventResult.total_discount());
    }


    public static void printBadge(Badge badge){
        System.out.println(OutputConfig.BADGE_MESSAGE.get());
        System.out.println(badge.getName());
    }

}