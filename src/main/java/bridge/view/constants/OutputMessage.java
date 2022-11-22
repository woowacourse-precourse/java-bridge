package bridge.view.constants;

/**
 * 게임 안내를 위한 출력 메시지를 저장하는 상수 클래스
 */
public enum OutputMessage {

    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_RETRY_OR_QUIT(String.format(
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            CommandKeyword.RETRY.getKey(), CommandKeyword.QUIT.getKey()
    )),
    ASK_MOVING(String.format(
            "이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            MovingKeyword.UP.getKey(), MovingKeyword.DOWN.getKey()
    )),
    SHOW_RESULT("최종 게임 결과");

    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
