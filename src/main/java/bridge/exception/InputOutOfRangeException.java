package bridge.exception;

public class InputOutOfRangeException extends IllegalArgumentException{
    public InputOutOfRangeException() {
        super("[ERROR] 다리 길이는 3이상 20이하로 입력해야 합니다.");
    }
}