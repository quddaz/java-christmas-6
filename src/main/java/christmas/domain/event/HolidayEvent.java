package christmas.domain.event;

import christmas.dto.EventInfo;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class HolidayEvent implements Event{
    private final int PLUS_DISCOUNT_RATE = 2023;
    private final List<DayOfWeek> specialList = List.of(
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY
    );
    @Override
    public boolean isApplicable(EventInfo eventInfo) {
        DayOfWeek now = LocalDate.of(YEAR,MONTH,eventInfo.day()).getDayOfWeek();
        return specialList.contains(now);
    }

    @Override
    public int discount(EventInfo eventInfo) {
        return eventInfo.main_count() * PLUS_DISCOUNT_RATE;
    }

    @Override
    public String discountPrint(EventInfo eventInfo) {
        if(eventInfo.main_count() != 0)
            return String.format(EVENT_FORMAT, "휴일 할인", discount(eventInfo));
        return "";
    }

}
