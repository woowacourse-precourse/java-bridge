package bridge.Constant;

public enum Message {

    START("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    START_OR_END("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    GAME_STATE("게임 성공 여부: "),
    COUNT("총 시도한 횟수: "),
    WIN("성공"),
    LOSE("실패");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
