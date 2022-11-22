package bridge.util;

public enum ErrorMessage {
    ERROR_IS_NOT_DIGIT("[ERROR] 다리의 길이는 정수여야 합니다."),
    ERROR_BRIGE_SIZE_RANGE("[ERROR] 다리의 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_MOVING("[ERROR] 이동할 칸은 U 또는 D를 입력해야 합니다."),
    ERROR_RETRY_OR_QUIT("[ERROR] R(재시작) 또는 Q(종료)를 입력해야 합니다.");
    private String message;
    ErrorMessage(String message){
        this.message=message;
    }
    public String print(){
        return message;
    }
}
