package christmas.domain.event;

import christmas.dto.EventInfo;

public class ChristmasEvent implements Event{
    private final int PLUS_DISCOUNT_RATE = 100;

    private final int CHRISTMAS_DAY = 25;
    @Override
    public boolean isApplicable(EventInfo eventInfo) {
        return eventInfo.day() <= CHRISTMAS_DAY;
    }

    @Override
    public int discount(EventInfo eventInfo) {
        return eventInfo.day() * PLUS_DISCOUNT_RATE;
    }

    @Override
    public String discountPrint(EventInfo eventInfo) {
        return String.format(EVENT_FORMAT, "크리스마스 디데이 할인", discount(eventInfo));
    }

}
