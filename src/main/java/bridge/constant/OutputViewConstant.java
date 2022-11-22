package bridge.constant;

public enum OutputViewConstant {
    PREFIX("[ "),
    SPACE(" "),
    DIVIDING_LINE(" | "),
    SUFFIX(" ]"),
    NEW_LINE("\n"),
    INTRO_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    FINAL_RESULT_MESSAGE("최종 게임 결과"),
    GAME_SUCCESS_OR_FAIL_MESSAGE("게임 성공 여부: "),
    TOTAL_TRY_COUNT_MESSAGE("총 시도한 횟수: "),
    ;

    private final String symbol;

    OutputViewConstant(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
