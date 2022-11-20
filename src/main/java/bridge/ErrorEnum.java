package bridge;

public enum ErrorEnum {
    PREFIX("[ERROR] "),
    NUMERIC(" 숫자로 변환할 수 없는 입력입니다.");

    private String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
