package bridge.constant;

public enum ErrorMessage {
    NO_NUMERIC_VALUE(" 숫자를 입력해주세요."), NUMBER_RANGE_IS_WRONG(" 3이상 20이하의 숫자를 입력해주세요.");
    String errorMessage;
    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}
