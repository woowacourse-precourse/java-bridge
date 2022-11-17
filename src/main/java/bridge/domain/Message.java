package bridge.domain;

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE("다리의 길이를 입력해주세요."),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
