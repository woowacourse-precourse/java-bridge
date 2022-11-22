package bridge.util.message;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    OUT_OF_RANGE("다리의 길이가 범위값에 맞지 않습니다."),
    ONLY_NUMERIC("숫자만 입력해 주셔야 합니다."),
    UP_OR_DOWN("'U' 또는 'D' 만 입력 가능합니다."),
    ONE_CHARACTER("하나의 문자만 입력 가능합니다.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return PREFIX+this.message;
    }
}
