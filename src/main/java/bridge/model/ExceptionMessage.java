package bridge.model;

public enum ExceptionMessage {

    LENGTH_OVER_RANGE_ERROR_MESSAGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    LENGTH_NON_NUMBER_ERROR_MESSAGE("[ERROR] 다리 길이는 숫자여야 합니다."),
    MOVING_NON_FORMAT_ERROR_MESSAGE("[ERROR] 이동할 칸은 U,D 이어야만 합니다."),
    RETRY_NON_FORMAT_ERROR_MESSAGE("ERROR 재시도 문자는 R,Q 이어야만 가능합니다.");

    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
