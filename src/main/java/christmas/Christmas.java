package christmas;

import christmas.domain.Order;
import christmas.domain.badge.Badge;
import christmas.domain.event.Event;
import christmas.domain.event.PromotionEvent;
import christmas.domain.menu.Menu;
import christmas.dto.BonusMenu;
import christmas.dto.EventInfo;
import christmas.dto.EventResult;
import christmas.exception.CustomException;
import christmas.parser.DayParser;
import christmas.parser.MenuParser;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Christmas {

    private final List<Event> events;
    private final PromotionEvent promotionEvent;
    private static final int MIN_EVENT_PRICE = 10_000;

    public Christmas(List<Event> events, PromotionEvent promotionEvent) {
        this.events = events;
        this.promotionEvent = promotionEvent;
    }

    public void run(){
        OutputView.printStart();
        int day = getDay();
        Order order = new Order(getOrder());

        OutputView.printInfo(day);

        OutputView.printMenu(order.getPrintMenu());
        OutputView.printNonDiscount(order.getTotalMoney());

        EventInfo eventInfo = new EventInfo(day, order.getDessertCount(), order.getMainCount(), order.getTotalMoney());

        EventResult eventResult = getEventResult(eventInfo);

        BonusMenu bonusMenu = promotionEvent.bonusMenu(eventInfo);
        OutputView.printBonusMenu(bonusMenu);

        OutputView.printEventInfo(eventResult);

        OutputView.printDiscountMoney(eventResult.total_discount());

        OutputView.printTotalMoney(eventResult);

        Badge badge = Badge.from(eventResult.total_discount());
        OutputView.printBadge(badge);
    }

    private int getDay(){
        return retryInput(() -> {
            OutputView.printDateInput();
            return DayParser.parse(InputView.readInput());
        });
    }

    private Map<Menu, Integer> getOrder(){
        return retryInput(() ->{
           OutputView.printOrderInput();
           return MenuParser.parse(InputView.readInput());
        });
    }

    private EventResult getEventResult(EventInfo eventInfo){
        if(eventInfo.total_price() < MIN_EVENT_PRICE)
            return new EventResult("", eventInfo.total_price(), 0);

        StringBuilder sb = new StringBuilder();
        List<Event> events1 = events.stream()
                .filter(e -> e.isApplicable(eventInfo))
                .toList();
        events1.stream()
                .forEach(e -> sb.append(e.discountPrint(eventInfo)));

        int total_discount =  events1.stream()
                .mapToInt(e -> e.discount(eventInfo))
                .sum();

        return new EventResult(sb.toString(), eventInfo.total_price(), total_discount);
    }

    private <T> T retryInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (CustomException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
