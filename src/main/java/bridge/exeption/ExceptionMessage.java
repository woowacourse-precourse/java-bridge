package bridge.exeption;

public enum ExceptionMessage {
    NOT_NUM_ERROR("숫자를 입력해야 합니다."),
    MOVE_INPUT_ERROR("U 또는 D를 입력해야 합니다."),
    RETRY_INPUT_ERROR("R 또는 Q를 입력해야 합니다."),
    OUT_OF_RANGE_INPUT_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    private String error;
    private static final String ERROR = "[ERROR] ";
    ExceptionMessage(String error){
        this.error = ERROR + error;
    }
    public String getError(){return error;}
}
