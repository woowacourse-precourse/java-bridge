package bridge.util;

import bridge.domain.BridgeType;

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

    public static void validateMovingType(String input){
        String upperInput = input.toUpperCase();
        if(!BridgeType.isContains(upperInput)){
            throw new IllegalArgumentException("[ERROR] 입력된 이동 옵션 값이 유효한 옵션이 아닙니다.");
        }
    }

    public static void validateStringIsEnglish(String input){
        if(!input.matches("^[a-zA-Z]*$")){
            throw new IllegalArgumentException("[ERROR] 입력 값은 영어여야 합니다.");
        }
    }

    public static void validateRestartOption(String input){
        String upperInput = input.toUpperCase();
        if(!upperInput.equals("Q") && !upperInput.equals("R")){
            throw new IllegalArgumentException("[ERROR] 입력된 재시작 옵션 값이 유효한 옵션이 아닙니다.");
        }
    }
}

