package bridge.constant;

public enum PrintMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.\n"),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)\n"),
    RESULT_MAP("최종 게임 결과"),
    RESULT_IS_SUCCESS("게임 성공 여부: %s\n"),
    RESULT_TRIALS("총 시도한 횟수: %d");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}
