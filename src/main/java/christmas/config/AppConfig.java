package christmas.config;

import christmas.Christmas;
import christmas.domain.event.ChristmasEvent;
import christmas.domain.event.Event;
import christmas.domain.event.HolidayEvent;
import christmas.domain.event.PromotionEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekdayEvent;
import java.util.List;

public class AppConfig {
    private final PromotionEvent promotionEvent;
    private final List<Event> events = List.of(
            new ChristmasEvent(),
            new WeekdayEvent(),
            new HolidayEvent(),
            new SpecialEvent(),
            new PromotionEvent()
    );
    private final Christmas christmas;

    public AppConfig() {
        this.promotionEvent = new PromotionEvent();
        this.christmas = new Christmas(events, promotionEvent);
    }

    public Christmas christmas(){
        return christmas;
    }
}
