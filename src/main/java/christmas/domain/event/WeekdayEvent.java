package christmas.domain.event;

import christmas.dto.EventInfo;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekdayEvent implements Event{
    private final int PLUS_DISCOUNT_RATE = 2023;
    private final List<DayOfWeek> weekList = List.of(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.SUNDAY
    );


    @Override
    public boolean isApplicable(EventInfo eventInfo) {
        DayOfWeek now = LocalDate.of(YEAR,MONTH,eventInfo.day()).getDayOfWeek();
        return weekList.contains(now);
    }

    @Override
    public int discount(EventInfo eventInfo) {
        return eventInfo.dessert_count() * PLUS_DISCOUNT_RATE;
    }

    @Override
    public String discountPrint(EventInfo eventInfo) {
        if(eventInfo.dessert_count() != 0)
            return String.format(EVENT_FORMAT, "평일 할인", discount(eventInfo));
        return "";
    }
}
