package bridge.enums;

public enum Announcement {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요."),
    INPUT_MOVING_DIRECTION("이동할 칸을 선택해주세요."),
    GAME_FINISH("최종 게임 결과"),
    GAME_CLEAR_OR_NOT("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    TOTAL_TRY_COUNT("총 시도한 횟수: ");
    private final String message;

    Announcement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
