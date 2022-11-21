package bridge.constant;

public enum ErrorMessage {
    NO_NUMERIC_VALUE(" 숫자를 입력해주세요."), NUMBER_RANGE_IS_WRONG(" 3이상 20이하의 숫자를 입력해주세요."),
    WRONG_LENGTH(" 하나의 문자를 입력해세요"), WRONG_FORMAT(" 괄호 안 문자 중,하나의 문자만 입력해주세요");
    String errorMessage;
    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}
