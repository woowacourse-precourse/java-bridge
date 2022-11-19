package bridge.exeption;

public enum ExceptionMessage {
    NOT_NUM_ERROR("숫자를 입력해야 합니다.");
    private String error;
    ExceptionMessage(String error){
        this.error = error;
    }
    public String getError(){return error;}
}
