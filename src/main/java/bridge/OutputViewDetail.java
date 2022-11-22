package bridge;

public enum OutputViewDetail {
    NEW_LINE("\n"),
    CAN_MOVE(" O "),
    CANNOT_MOVE(" X "),
    NONE("   "),
    START_LINE("["),
    MIDDLE_LINE("|"),
    END_LINE("]"),
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: %s"),
    TRY_NUMBER("총 시도한 횟수: %d"),
    SUCCESS("성공"),
    FAIL("실패"),;

    private final String message;

    OutputViewDetail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
