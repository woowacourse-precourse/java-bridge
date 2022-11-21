package bridge.view;

public enum Messages {
    ERROR_INPUT_NUMBER("[ERROR] 입력은 숫자만 가능합니다."),
    ERROR_BRIDGE_SIZE("[ERROR] 다리의 길이는 3 ~ 20까지만 입력 가능합니다."),
    ERROR_MOVE("[ERROR] \"U\"와 \"D\"만 입력 가능합니다."),
    ERROR_GAME_COMMAND("[ERROR] \"R\"과 \"Q\"만 입력 가능합니다."),
    VIEW_START_GAME("다리 건너기 게임을 시작합니다."),
    VIEW_SELECT_UP_DOWN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    VIEW_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    VIEW_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
