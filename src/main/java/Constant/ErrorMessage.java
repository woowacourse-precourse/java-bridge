package Constant;

public enum ErrorMessage {
    INVALID_DIGIT("입력받은 내용이 숫자가 아닙니다.");
    private static final String errorBase="[ERROR]";
    private final String errorMsg;
    ErrorMessage(String s) {
        this.errorMsg=s;
    }
    public String getErrorMsg(){
        return errorBase+errorMsg;
    }
}
