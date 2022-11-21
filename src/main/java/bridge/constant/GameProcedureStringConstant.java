package bridge.constant;

public enum GameProcedureStringConstant {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
    WHERE_TO_GO_INPUT_MESSAGE(
            "이동할 칸을 선택해주세요. (" + UpDownConstant.UP.getLocation() + ": " + UpDownConstant.UP.getSymbol() + ", "
                    + UpDownConstant.DOWN.getLocation() + ": " + UpDownConstant.DOWN.getSymbol()+")"),
    GAME_RETRY_OR_EXIT_INPUT_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요."),
    GAME_SUCCESS_OR_FAIL_MESSAGE("게임 성공 여부: "),
    GAME_FINISH_MESSAGE("최종 게임 결과"),
    GAME_TRY_COUNT_MESSAGE("총 시도한 횟수: ");

    private final String message;

    GameProcedureStringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
