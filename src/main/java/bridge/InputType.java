package bridge;

public enum InputType {
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    READ_MOVING("이동할 칸을 선택해주세요. (위: %s, 아래: %S)"),
    READ_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)");

    private final String message;

    InputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
