package bridge.util.message;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    OUT_OF_RANGE("다리의 길이가 범위값에 맞지 않습니다."),
    INPUT_NUMERIC("숫자만 입력해 주셔야 합니다.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return PREFIX+this.message;
    }
}
