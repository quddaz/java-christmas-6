package christmas.domain.event;

import christmas.dto.EventInfo;
import java.util.List;

public class SpecialEvent implements Event{
    private static final int SPECIAL_DISCOUNT_RATE = 1000;
    private final List<Integer> dayList = List.of(3,10,17,24,25,31);


    @Override
    public boolean isApplicable(EventInfo eventInfo) {
        return dayList.contains(eventInfo.day());
    }

    @Override
    public int discount(EventInfo eventInfo) {
        return SPECIAL_DISCOUNT_RATE;
    }

    @Override
    public String discountPrint(EventInfo eventInfo) {
        return String.format(EVENT_FORMAT, "특별 행사", discount(eventInfo));
    }
}
