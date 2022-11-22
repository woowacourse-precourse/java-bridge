package bridge;

public enum Message {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_REQUEST("다리 길이를 입력해주세요."),
    MOVING_REQUEST("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}