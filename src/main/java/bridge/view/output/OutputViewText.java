package bridge.view.output;

public abstract class OutputViewText {
    protected static final String NOTHING = " ";
    protected static final String MOVE_CORRECT = "O";
    protected static final String MOVE_WRONG = "X";

    protected static final String BRIDGE_DELIMITER = " | ";
    protected static final String BRIDGE_PREFIX = "[ ";
    protected static final String BRIDGE_SUFFIX = " ]";

    protected static final String SUCCESS = "성공";
    protected static final String FAIL = "실패";

    protected static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    protected static final String FINAL_GAME_RESULT = "최종 게임 결과";
    protected static final String SUCCESS_OR_NOT = "\n게임 성공 여부: ";
    protected static final String COUNT_OF_TRY = "총 시도한 횟수: ";

}
