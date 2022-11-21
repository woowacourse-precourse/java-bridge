package bridge.exception;

public class CheckBridgeLengthException extends IllegalArgumentException{
    public static final String CHECK_INPUT_RANGE = "[ERROR] 3 ~ 20 사이의 숫자를 입력해 주세요";
    public CheckBridgeLengthException(){
        super(CHECK_INPUT_RANGE);
    }
}
