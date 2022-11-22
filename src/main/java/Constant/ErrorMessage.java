package Constant;

public enum ErrorMessage {
    INVALID_DIGIT("입력받은 내용이 숫자가 아닙니다."),
    ILLEGAL_LIST_INDEX("index가 배열의 범위를 벗어났습니다.");
    private static final String errorBase="[ERROR]";
    private final String errorMsg;
    ErrorMessage(String s) {
        this.errorMsg=s;
    }
    public String getErrorMsg(){
        return errorBase+errorMsg;
    }
}
