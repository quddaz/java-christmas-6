package christmas.view;

public enum OutputConfig {
    PURCHASE_MESSAGE("구입금액을 입력해 주세요.");

    private final String format;

    OutputConfig(String format) {
        this.format = format;
    }

    public String get() {
        return format;
    }
    }