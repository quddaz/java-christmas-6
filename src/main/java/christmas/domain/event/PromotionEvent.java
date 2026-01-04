package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.dto.BonusMenu;
import christmas.dto.EventInfo;

public class PromotionEvent implements Event {
    private static final Menu PROMOTION_MENU = Menu.샴페인;
    private static final int PROMOTION_RATE = 120000;

    public BonusMenu bonusMenu(EventInfo eventInfo){
        if(isApplicable(eventInfo))
            return new BonusMenu(PROMOTION_MENU.name(), 1);
        return new BonusMenu("없음", 0);
    }
    @Override
    public boolean isApplicable(EventInfo eventInfo) {
        return eventInfo.total_price() >= PROMOTION_RATE;
    }

    @Override
    public int discount(EventInfo eventInfo) {
        return PROMOTION_MENU.getPrice();
    }

    @Override
    public String discountPrint(EventInfo eventInfo) {
        return String.format(EVENT_FORMAT, "증정 이벤트", discount(eventInfo));
    }
}
