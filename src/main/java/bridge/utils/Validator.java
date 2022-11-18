package bridge.utils;

import java.util.List;

public class Validator {
    private Validator(){}

    public static boolean isNumericString(String target){
        return target.chars().allMatch(Character::isDigit);
    }

    public static boolean isInRangeOfString(String target, String[] range){
        return List.of(range).contains(target);
    }

    public static boolean isInRangeOfNumber(int target, int start, int end){
        // TODO: 숫자로된 범위 안에 값이 존재하는지 확인
        return false;
    }
}
