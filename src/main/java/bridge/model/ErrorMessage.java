package bridge.model;

public enum ErrorMessage {

    INVALID_NUMERIC_VALUE("[ERROR] 3 이상 20 이하의 값을 입력해주세요"),
    INVALID_DIRECTION_VALUE("[ERROR] U 혹은 D를 입력해주세요."),
    INVALID_RESTART_VALUE("[ERROR] R 혹은 Q를 입력해주세요.");

    private final String output;

    ErrorMessage(String output){
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
