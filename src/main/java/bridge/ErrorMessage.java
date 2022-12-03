package bridge;

public enum ErrorMessage {
    NOTNULL("값을 입력해주세요"),
    BRIDGE_SIZE_OUT_OF_RANGE("3 이상 20 이하의 숫자를 입력해주세요"),
    MOVING_OUT_OF_RANGE("U 또는 D를 입력해주세요"),
    GAME_COMMAND_OUT_OF_RANGE("R 또는 Q를 입력해주세요");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString(){
        return "[ERROR] " + errorMessage;
    }
}


