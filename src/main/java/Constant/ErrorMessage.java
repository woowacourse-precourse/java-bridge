package Constant;

public enum ErrorMessage {
    INVALID_DIGIT("입력받은 내용이 숫자가 아닙니다."),
    INVALID_MOVE("이동을 위한 값은 U나 D만 가능합니다.");
    private static final String errorBase="[ERROR]";
    private final String errorMsg;
    ErrorMessage(String s) {
        this.errorMsg=s;
    }
    public String getErrorMsg(){
        return errorBase+errorMsg;
    }
}
