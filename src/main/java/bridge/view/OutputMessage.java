package bridge.view;

public enum OutputMessage {

    GAME_RESULT("최종 게임 결과"),
    WIN_GAME("게임 성공 여부: 성공"),
    LOSE_GAME("게임 성공 여부: 실패"),
    TRY("총 시도한 횟수: "),
    CORRECT(" O |"),
    WRONG(" X |"),
    JUMP_BAR("   |"),
    START("["),
    BAR("|"),
    END("]");

    private final String outputMsg;

    OutputMessage(String outputMsg) {
        this.outputMsg = outputMsg;
    }

    public String getOutputMsg() {
        return outputMsg;
    }
}
