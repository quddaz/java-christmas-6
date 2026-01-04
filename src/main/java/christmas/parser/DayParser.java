package christmas.parser;

import christmas.exception.CustomException;
import christmas.exception.ExceptionMessage;

public class DayParser {
    private DayParser(){}

    public static int parse(String input){
        int day = parseInteger(input);
        validateRange(day);

        return day;
    }

    private static int parseInteger(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new CustomException(ExceptionMessage.INVALID_DATE);
        }
    }

    private static void validateRange(int day){
        if(day < 1 || day > 31)
            throw  new CustomException(ExceptionMessage.INVALID_DATE);
    }
}
