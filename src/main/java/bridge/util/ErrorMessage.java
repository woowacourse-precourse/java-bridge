package bridge.util;

public enum ErrorMessage {
    ERROR_IS_NOT_DIGIT("[ERROR] 다리의 길이는 정수이어야 합니다.");
    private String message;
    ErrorMessage(String message){
        this.message=message;
    }
    public String print(){
        return message;
    }
}
