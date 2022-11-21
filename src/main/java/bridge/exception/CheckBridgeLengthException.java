package bridge.exception;

public class CheckBridgeLengthException extends IllegalArgumentException{
    public CheckBridgeLengthException(){
        super("[ERROR] 3 ~ 20 사이의 숫자를 입력해 주세요");
    }
}
