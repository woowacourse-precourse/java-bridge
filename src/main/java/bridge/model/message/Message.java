package bridge.model.message;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE("다리의 길이를 입력해주세요"),
    GO_DOWN("D"),
    GO_UP("U"),
    INPUT_MOVING("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RE_START("R"),
    QUIT("Q");



    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
