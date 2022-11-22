package bridge.domain;

import bridge.validator.Validator;

public class GameResult {

    private static final String FRONT_BRIDGE = "[ ";
    private static final String BACK_BRIDGE = " ]\n";
    private static final String RIGHT = "O";
    private static final String WRONG = "X";
    private static final String BLANK = " ";
    private static final String PIPE = " | ";
    private static final int FIRST_BRIDGE = 1;

    private String upBridge;
    private String downBridge;

    public GameResult(String upBridge, String downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public String getFinalResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(upBridge).append(downBridge);
        return stringBuilder.toString();
    }

    public String makeBridgeResult(String input, boolean isMatch, BridgeMatcher bridgeMatcher) {
        StringBuilder stringBuilder = new StringBuilder();

        bridgeMatcher.addTrueOrFalse(isMatch);
        makeAnswerBridge(input, isMatch, bridgeMatcher);
        stringBuilder.append(upBridge).append(downBridge);

        return stringBuilder.toString();
    }

    private void makeAnswerBridge(String input, boolean isMatch, BridgeMatcher bridgeMatcher) {
        String matchAnswer = insertMatchAnswer(isMatch);
        int size = bridgeMatcher.calculateSize();

        if (size == FIRST_BRIDGE) {
            makeFirstBridgeResult(input, matchAnswer);
        }
        if (size != FIRST_BRIDGE) {
            makeRestBridgeResult(input, matchAnswer);
        }
    }

    private void makeFirstBridgeResult(String input, String matchAnswer) {
        if (input.equals(Validator.MOVE_UP)) {
            upBridge = FRONT_BRIDGE + matchAnswer + BACK_BRIDGE;
            downBridge = FRONT_BRIDGE + BLANK + BACK_BRIDGE;
        } else if (input.equals(Validator.MOVE_DOWN)) {
            upBridge = FRONT_BRIDGE + BLANK + BACK_BRIDGE;
            downBridge = FRONT_BRIDGE + matchAnswer + BACK_BRIDGE;
        }
    }

    private void makeRestBridgeResult(String input, String matchAnswer) {
        if (input.equals(Validator.MOVE_UP)) {
            upBridge = upBridge.replace(BACK_BRIDGE, PIPE) + matchAnswer + BACK_BRIDGE;
            downBridge = downBridge.replace(BACK_BRIDGE, PIPE) + BLANK + BACK_BRIDGE;
        } else if (input.equals(Validator.MOVE_DOWN)) {
            upBridge = upBridge.replace(BACK_BRIDGE, PIPE) + BLANK + BACK_BRIDGE;
            downBridge = downBridge.replace(BACK_BRIDGE, PIPE) + matchAnswer + BACK_BRIDGE;
        }
    }

    private String insertMatchAnswer(boolean isMatch) {
        if (!isMatch) {
            return WRONG;
        }

        return RIGHT;
    }
}