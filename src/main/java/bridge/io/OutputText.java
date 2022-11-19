package bridge.io;

public enum OutputText {
    GAME_END("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: %s"),
    ATTEMPT("총 시도한 횟수: %d");

    private final String outputText;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    OutputText(String outputText) {
        this.outputText = outputText;
    }

    public static String getGameResultMsg(boolean success) {
        if (success) {
            return String.format(GAME_RESULT.getOutputText(), SUCCESS);
        }

        return String.format(GAME_RESULT.getOutputText(), FAIL);
    }

    public String getOutputText() {
        return outputText;
    }
}
