package bridge.constant;

public enum ErrorCode {

    OUT_OF_RANGE("[ERROR] 입력 범위를 벗어났습니다."),
    WRONG_WORD_IN_LIST("[ERROR] 리스트 내에 잘못된 문자열이 있습니다."),
    WRONG_INPUT("[ERROR] 잘못된 입력값이 있습니다.")

    ;

    private final String errorMessage;
    ErrorCode(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return this.errorMessage;
    }
}
