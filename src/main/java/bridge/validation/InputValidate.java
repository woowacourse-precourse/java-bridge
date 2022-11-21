package bridge.validation;

import java.util.NoSuchElementException;

public class InputValidate {
    private static final String BRIDGE_SIZE_MESSAGE = "[ERROR] 3 이상 20 이하의 길이를 입력해주세요";
    private static final String MOVING_FORMAT_MESSAGE = "[ERROR] U 나 D 만 입력해주세요";
    private static final String RESTART_FORMAT_MESSAGE = "[ERROR] R 이나 Q 만 입력해주세요";
    private static final String BRIDGE_INTEGER_MESSAGE =  "[ERROR] 숫자만 입력해주세요";
    private static final Integer MIN_INTEGER_SIZE = 3;
    private static final Integer MAX_INTEGER_SIZE = 20;

    public void validateSizeFormat(int length){
        if(length < MIN_INTEGER_SIZE || length > MAX_INTEGER_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_MESSAGE);
        }
    }
    public void validateMovingFormat(String moving){
        if(moving.indexOf("U") == -1 && moving.indexOf("D") == -1){
            throw new IllegalArgumentException(MOVING_FORMAT_MESSAGE);
        }
    }
    public void validateGameCommendFormat(String gameCommend){
        if(gameCommend.indexOf("R") == -1 && gameCommend.indexOf("Q") == -1){
            throw new IllegalArgumentException(RESTART_FORMAT_MESSAGE);
        }
    }

    public void validateSizeIntFormat(String input) {
        try{
            Double.parseDouble(input);
        }
        catch(NumberFormatException e){
            System.out.print(BRIDGE_INTEGER_MESSAGE);
            throw new NoSuchElementException();
        }
    }
}