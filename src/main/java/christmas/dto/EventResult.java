package christmas.dto;

public record EventResult(
        String result,
        int total_money,
        int total_discount
) {
}
