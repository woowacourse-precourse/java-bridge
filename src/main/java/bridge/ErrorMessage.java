package bridge;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    INPUT_MOVE_BRIDGE_ERROR("위 칸은 'U', 아래 칸은 'D'를 입력해주세요.");


    private String script;

    ErrorMessage(String script) {
        this.script = script;
    }

    public static void inputMoveBridgeError() {
        System.out.println(ERROR_MESSAGE.script + INPUT_MOVE_BRIDGE_ERROR.script);
    }
}
