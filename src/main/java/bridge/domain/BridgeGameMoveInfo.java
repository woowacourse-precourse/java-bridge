package bridge.domain;


import static bridge.domain.BridgeGamePosition.UP;

public class BridgeGameMoveInfo {
    private static final String MOVE_COMMAND_IS_NOT_NULL = "다음 위치에 null 이 들어올 수 없습니다";
    private static final String BLANK_SIGN = "   |";
    private static final String ANSWER_SIGN = " O |";
    private static final String WRONG_SIGN = " X |";
    private final StringBuilder up = new StringBuilder("[");
    private final StringBuilder down = new StringBuilder("[");

    public void moveInfo(BridgeGamePosition move, boolean correct) {
        validateMove(move);

        if (move == UP) {
            addBridgeMove(up, down, correct);
            return;
        }
        addBridgeMove(down, up, correct);
    }

    private void validateMove(BridgeGamePosition move) {
        if (move == null) {
            throw new IllegalArgumentException(MOVE_COMMAND_IS_NOT_NULL);
        }
    }

    private void addBridgeMove(StringBuilder signBuilder, StringBuilder spaceBuilder, boolean correct) {
        spaceBuilder.append(BLANK_SIGN);
        if (correct) {
            signBuilder.append(ANSWER_SIGN);
            return;
        }
        signBuilder.append(WRONG_SIGN);
    }
}
