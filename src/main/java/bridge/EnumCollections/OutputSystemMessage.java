package bridge.EnumCollections;

public enum OutputSystemMessage {
    GAME_START_OUTPUT("다리 건너기 게임을 시작합니다."),
    GAME_RESULT_OUTPUT("최종 게임 결과"),
    GAME_SUCCESS_OUTPUT("게임 성공 여부: "),
    RUN_GAME_NUMBER_OUTPUT("총 시도한 횟수: ");

    private String message;

    OutputSystemMessage(String message) {
        this.message = message;
    }

    public static String getMessage(OutputSystemMessage situation) {
        return situation.message;
    }
}
