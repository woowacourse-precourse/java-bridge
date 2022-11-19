package bridge;

public enum Error {
    NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    NOT_IN_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_U_OR_D("[ERROR] U 또는 D 만 입력 가능합니다."),
    NOT_R_OR_Q("[ERROR] R 또는 Q 만 입력 가능합니다. ");

    private final String message;

    Error(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
