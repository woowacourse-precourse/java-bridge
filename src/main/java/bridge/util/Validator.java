package bridge.util;

import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateBridgeLength(int length){
        if(length < 3 || length > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상 20 이하여야 합니다.");
        }
    }

    public static void validateStringIsNumeric(String input){
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야합니다.");
        }
    }
}

