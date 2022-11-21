package bridge.validation;

import java.util.NoSuchElementException;

public class InputValidate {
    private static final String BRIDGE_SIZE_MESSAGE = "[ERROR] 3 이상 20 이하의 길이를 입력해주세요";
    private static final String MOVING_FORMAT_MESSAGE = "[ERROR] U 나 D 만 입력해주세요";
    private static final String RESTART_FORMAT_MESSAGE = "[ERROR] R 이나 Q 만 입력해주세요";
    private static final String BRIDGE_INTEGER_MESSAGE =  "[ERROR] 숫자만 입력해주세요";
    private static final Integer MIN_INTEGER_SIZE = 3;
    private static final Integer MAX_INTEGER_SIZE = 20;

    /**
     * 다리 길이가 3 미만, 20 초과 이면 예외 처리
     * @param length : 입력받은 다리 길이
     * */
    public void validateSizeFormat(int length){
        if(length < MIN_INTEGER_SIZE || length > MAX_INTEGER_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_MESSAGE);
        }
    }
    /**
     * 움직임 입력이 U 나 D가  아니면 예외 처리
     * @param moving : 입력받은 움직임
     * */
    public void validateMovingFormat(String moving){
        if(moving.indexOf("U") == -1 && moving.indexOf("D") == -1){
            throw new IllegalArgumentException(MOVING_FORMAT_MESSAGE);
        }
    }
    /**
     * 재시작 입력이 R, Q 가 아니면 예외 처리
     * @param gameCommend : 입력받은 재시작 명령어 ( R, Q )
     * */
    public void validateGameCommendFormat(String gameCommend){
        if(gameCommend.indexOf("R") == -1 && gameCommend.indexOf("Q") == -1){
            throw new IllegalArgumentException(RESTART_FORMAT_MESSAGE);
        }
    }

    /**
     * 입력받은 다리 길이가 숫자가 아닌 문자를 입력받았을 때 예외 처리
     * @param length : 입력받은 다리 길이
     * */
    public void validateSizeIntFormat(String length) {
        try{
            Double.parseDouble(length);
        }
        catch(NumberFormatException e){
            System.out.print(BRIDGE_INTEGER_MESSAGE);
            throw new NoSuchElementException();
        }
    }
}