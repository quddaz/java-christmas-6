package christmas.view;

public enum OutputConfig {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE_INPUT_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_INPUT_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    INFO_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    MENU_MESSAGE("<주문 메뉴>"),
    MENU_INFO_MESSAGE("%s %d개\n"),
    NON_DISCOUNT_INFO_MESSAGE("<할인 전 총주문 금액>"),
    NON_DISCOUNT_MONEY_MESSAGE("%,d원\n"),
    BONUS_MENU_MESSAGE("<증정 메뉴>"),
    NON_BONUS_MESSAGE("없음"),
    BONUS_MESSAGE("%s %d개"),
    EVENT_MESSAGE("<혜택 내역>"),
    DISCOUNT_AFTER_MESSAGE("<총혜택 금액>"),
    EVENT_INFO_MESSAGE("%s: -%,d원\n"),
    TOTAL_EVENT_MESSAGE("-%,d원\n"),
    TOTAL_EVENT_MONEY_MESSAGE("-%,d원\n"),
    MONEY_MESSAGE("<할인 후 예상 결제 금액>"),
    TOTAL_MONEY_MESSAGE("%,d원\n"),
    BADGE_MESSAGE("<12월 이벤트 배지>");


    private final String format;

    OutputConfig(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
    }