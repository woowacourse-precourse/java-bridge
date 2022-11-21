package bridge.message;

public enum OutputMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    public final String value;

    OutputMessage(String value) {
        this.value = value;
    }
}
