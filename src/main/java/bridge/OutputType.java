package bridge;

public enum OutputType {
    PRINT_GAME_START("다리 건너기 게임을 시작합니다.\n"),
    PRINT_MAP_TITLE("최종 게임 결과"),
    PRINT_MAP_FRONT("[ %s "),
    PRINT_MAP_MID("| %s "),
    PRINT_MAP_BACK("]\n"),
    PRINT_RESULT("게임 성공 여부: %s\n" + "총 시도한 횟수: %d");

    private final String message;

    OutputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
