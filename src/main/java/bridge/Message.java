package bridge;

public enum Message {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_RANGE_BRIDGE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_BRIDGE_MESSAGE("이동할 칸을 선택해주세요."),
    INPUT_SELECT_GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요.");

    private static final char UP_BRIDGE_KEY = 'U';
    private static final char DOWN_BRIDGE_KEY = 'D';
    private static final String BRIDGE_OPTIONS = "(위: " + UP_BRIDGE_KEY + ", 아래: " + DOWN_BRIDGE_KEY + ")";
    private static final char RETRY_GAME_KEY = 'R';
    private static final char QUIT_GAME_KEY = 'Q';
    private static final String GAME_POTIONS = "(재시도: " + RETRY_GAME_KEY + ", 종료:" + QUIT_GAME_KEY + ")";
    private String script;
    Message(String script) {
        this.script = script;
    }

    public void gameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void inputRangeBridgeMessage(){
        System.out.println(INPUT_RANGE_BRIDGE_MESSAGE);
    }


}
