package bridge;

public enum Message {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_RANGE_BRIDGE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_BRIDGE_MESSAGE("이동할 칸을 선택해주세요."),
    INPUT_SELECT_GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요.");

    private static final char UP_BRIDGE = 'U';
    private static final char DOWN_BRIDGE = 'D';
    private static final String BRIDGE_OPTIONS = "(위: " + UP_BRIDGE + ", 아래: " + DOWN_BRIDGE + ")";
    private static final char RETRY_GAME = 'R';
    private static final char QUIT_GAME = 'Q';
    private static final String GAME_POTIONS = "(재시도: " + RETRY_GAME + ", 종료:" + QUIT_GAME + ")";
    private String script;
    Message(String script) {
        this.script = script;
    }


}
