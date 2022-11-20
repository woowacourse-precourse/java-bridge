package bridge.view.enumeration;

public enum ErrorMessage {
    IS_NOT_NUMBER("[ERROR] 문자열이 아닌 숫자(정수)를 입력해주세요."),
    BRIDGE_SIZE_IS_NOT_IN_RANGE("[ERROR] 다리의 길이는 3부터 20사이의 숫자를 입력해주세요."),
    GAME_COMMAND_LENGTH_IS_NOT_ONE("[ERROR] 게임 재시작 여부는 문자 1개를 입력해주세요."),
    GAME_COMMAND_IS_NOT_R_AND_Q("[ERROR] 게임 재시작 여부는 R 또는 Q로 입력해주세요."),
    MOVING_LENGTH_IS_NOT_ONE("[ERROR] 이동할 칸은 문자 1개를 입력해주세요."),
    MOVING_IS_NOT_U_AND_D("[ERROR] 이동할 칸은 U 또는 D로 입력해주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}
