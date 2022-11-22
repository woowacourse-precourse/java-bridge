package bridge.Code;

public enum ErrorCode {
    NO_INTEGER("[ERROR] 입력 가능한 값은 정수 형태입니다."),
    BRIDGE_LENGTH_LIMIT("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_LIMIT("[ERROR] 이동할 칸은 'U', 'D'로만 입력 가능합니다."),
    NUMBER_VARIATION("[ERROR] 당첨 번호는 1에서 45 사이의 숫자입니다.");

    private String message;

    private ErrorCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}