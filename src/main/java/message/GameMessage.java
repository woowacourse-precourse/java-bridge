package message;

public enum GameMessage {
    Starting("다리 건너기 게임을 시작합니다.\n"),
    Bridge_Size("다리 길이를 입력해주세요."),
    Moving("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    Restarting("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    Result("최종 게임 결과");

    private final String message;
    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
