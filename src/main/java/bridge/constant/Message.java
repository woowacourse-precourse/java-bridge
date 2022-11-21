package bridge.constant;

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다."),
    RESTART("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)"),
    FINAL_RESULT("최종 게임 결과"),
    GAME_RESULT("\n게임 성공 여부 : "),
    SUCCESS("성공"),
    FAIL("실패"),
    TOTAL_TRY("총 시도한 횟수: %d");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
