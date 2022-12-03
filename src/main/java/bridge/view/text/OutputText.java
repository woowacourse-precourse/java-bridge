package bridge.view.text;

public enum OutputText {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_INPUT_REQUEST("다리의 길이를 입력해주세요."),
    MOVE_INPUT_REQUEST("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n"),
    RETRY_INPUT_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)\n"),
    GAME_RESULT_TITLE("최종 게임 결과"),
    GAME_CLEAR("게임 성공 여부: %s\n"),
    TRIAL_COUNT("총 시도한 횟수: %d\n"),

    MAP_START("[ "),
    MAP_END(" ]"),
    BLOCK_BORDER(" | "),
    STATE_CLEAR("성공"),
    STATE_FAIL("실패"),
    STATE_NONE("잘못된 상태"),
    ERROR_HEAD("[ERROR]");

    private String message;
    OutputText(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
