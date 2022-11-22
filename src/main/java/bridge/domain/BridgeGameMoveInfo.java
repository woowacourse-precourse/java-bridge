package bridge.domain;


import static bridge.domain.BridgeGamePosition.UP;

public class BridgeGameMoveInfo {
    private static final String MOVE_COMMAND_IS_NOT_NULL = "다음 위치에 null 이 들어올 수 없습니다";
    private static final String BLANK_SIGN = "   |";
    private static final String ANSWER_SIGN = " O |";
    private static final String WRONG_SIGN = " X |";
    private final StringBuilder up = new StringBuilder("[");
    private final StringBuilder down = new StringBuilder("[");
}
