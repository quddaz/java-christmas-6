package christmas.domain.event;


import christmas.dto.EventInfo;

public interface Event {
    int YEAR = 2023;
    int MONTH = 12;

    final static String EVENT_FORMAT = "%s: -%,d원\n";
    boolean isApplicable(EventInfo eventInfo);
    int discount(EventInfo eventInfo);
    String discountPrint(EventInfo eventInfo);
}
