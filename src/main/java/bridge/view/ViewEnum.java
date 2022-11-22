package bridge.view;

public enum ViewEnum {
    INPUT_BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_USER_MOVE_BRIDGE_MESSAGE("이동할 칸을 입력해주세요. (위: U, 아래: D)"),
    INPUT_WANT_RE_GAME_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    PRINT_START_BRIDGE("["),
    PRINT_CONTINUE_HAVE_BRIDGE(" %s |"),
    PRINT_CONTINUE_BRIDGE("   |"),
    PRINT_END_HAVE_BRIDGE(" %s ]\n"),
    PRINT_END_BRIDGE("   ]\n"),

    OUTPUT_GAME_START_MESSAGE("다리 건너기 게임을 시작합니다"),
    OUTPUT_GAME_RESULT_MAP_PRINT_MESSAGE("최종 게임 결과"),
    OUTPUT_GAME_RESULT_MESSAGE("게임 성공 여부: %s\n"),
    OUTPUT_TOTAL_GAME_COUNT_MESSAGE("총 시도한 횟수: %d");


    private String message;

    ViewEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
