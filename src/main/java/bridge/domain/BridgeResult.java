package bridge.domain;

public class BridgeResult {
    private final int BRIDGE_FIRST_TRY_INDEX = 0;
    private final int BRIDGE_ONE_TRY_SPACE_SIZE = 4;
    private final String BRIDGE_FAIL_SPACE_BLANK = "   ";
    private final String CLOSING_BRACKET = "]";

    private static StringBuilder upsideResult;
    private static StringBuilder downsideResult;

    public BridgeResult(StringBuilder upsideResult, StringBuilder downsideResult) {
        this.upsideResult = upsideResult;
        this.downsideResult = downsideResult;
    }

    public StringBuilder getUpsideResult() {
        return upsideResult;
    }

    public StringBuilder getDownsideResult() {
        return downsideResult;
    }

    public void replaceCloseBracket(int bracketIndex) {
        if (bracketIndex > BRIDGE_FIRST_TRY_INDEX) {
            upsideResult.replace(BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, "|");
            downsideResult.replace(BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, "|");
        }
    }

    private void moveUpside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1,bridgeGame.createMoveMark(moveSide, index));
        downsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1, BRIDGE_FAIL_SPACE_BLANK);
    }

    private void moveDownside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1, BRIDGE_FAIL_SPACE_BLANK);
        downsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1,bridgeGame.createMoveMark(moveSide, index));
    }

    private void moveFailUpside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide, index));
        downsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1, BRIDGE_FAIL_SPACE_BLANK);
    }

    private void moveFailDownside(BridgeGame bridgeGame, String moveSide, int index) {
        upsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1, BRIDGE_FAIL_SPACE_BLANK);
        downsideResult.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1,bridgeGame.createMoveMark(moveSide,index));
    }

    private void deleteBridgeOverSecondTry(int index) {
        upsideResult.delete(BRIDGE_ONE_TRY_SPACE_SIZE * index , 2 * BRIDGE_ONE_TRY_SPACE_SIZE * index + 1);
        downsideResult.delete(BRIDGE_ONE_TRY_SPACE_SIZE * index , 2 * BRIDGE_ONE_TRY_SPACE_SIZE * index + 1);
    }

    private void deleteBridgeFirstTry() {
        upsideResult.delete(1, BRIDGE_ONE_TRY_SPACE_SIZE);
        downsideResult.delete(1, BRIDGE_ONE_TRY_SPACE_SIZE);
    }

    private void appendClosingBracket() {
        upsideResult.append(CLOSING_BRACKET);
        downsideResult.append(CLOSING_BRACKET);
    }


    public void goBackOneBridge(int index) {
        if (index > BRIDGE_FIRST_TRY_INDEX) {
            deleteBridgeOverSecondTry(index);
            appendClosingBracket();
        }
        if (index == BRIDGE_FIRST_TRY_INDEX) {
            deleteBridgeFirstTry();
        }
    }

    public void moveSuccess(BridgeGame bridgeGame, String moveSide, int index) {
        if (bridgeGame.move(moveSide,index) && moveSide.equals("U")) {
            moveUpside(bridgeGame, moveSide, index);
        }
        if (bridgeGame.move(moveSide, index) && moveSide.equals("D")) {
            moveDownside(bridgeGame, moveSide, index);
        }
    }

    public void moveFail(BridgeGame bridgeGame, String moveSide, int index) {
        if (!bridgeGame.move(moveSide, index) && moveSide.equals("U")) {
            moveFailUpside(bridgeGame, moveSide, index);
        }
        if (!bridgeGame.move(moveSide, index) && moveSide.equals("D")) {
            moveFailDownside(bridgeGame, moveSide, index);
        }
    }

}
