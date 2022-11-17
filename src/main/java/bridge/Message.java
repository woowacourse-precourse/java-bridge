package bridge;

public enum Message {

    BRIDGE_OPTIONS("(위: U, 아래: D)"),
    GAME_OPTIONS("(재시도: R, 종료: Q)"),
    START_GAME_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_RANGE_BRIDGE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_BRIDGE_MESSAGE("이동할 칸을 선택해주세요."),
    INPUT_SELECT_GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요.");

    private String script;

    Message(String script) {
        this.script = script;
    }

    public static void startGameMessage() {
        System.out.println(START_GAME_MESSAGE.script);
    }

    public static void inputRangeBridgeMessage() {
        System.out.println(INPUT_RANGE_BRIDGE_MESSAGE.script);
    }

    public static void inputMoveBridgeMessage() {
        System.out.println(INPUT_MOVE_BRIDGE_MESSAGE.script + " " + BRIDGE_OPTIONS.script);
    }

    public static void inputSelectGameRetry() {
        System.out.println(INPUT_SELECT_GAME_RETRY.script + " " + GAME_OPTIONS.script);
    }

}
