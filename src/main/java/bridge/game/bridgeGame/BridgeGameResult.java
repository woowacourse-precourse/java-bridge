package bridge.game.bridgeGame;

import bridge.structure.BridgeMoveValue;

import java.util.List;

public class BridgeGameResult {

    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String BLANK = " ";


    private final List<String> bridgeGameResult;

    public BridgeGameResult(BridgeMoveValue bridgeMoveValue, boolean pass) {
        this.bridgeGameResult = makeResult(bridgeMoveValue, pass);
    }

    public List<String> getBridgeGameResult() {
        return bridgeGameResult;
    }

    private List<String> makeResult(BridgeMoveValue bridgeMoveValue, boolean passValue) {
        List<String> pass = isPass(bridgeMoveValue, passValue);
        if (pass != null) return pass;

        return notPass(bridgeMoveValue);
    }

    private List<String> isPass(BridgeMoveValue bridgeMoveValue, boolean passValue) {
        if (passValue) {
            List<String> up = isUp(bridgeMoveValue, CORRECT);
            if (up != null) return up;

            return isDown(CORRECT);
        }

        return null;
    }

    private static List<String> notPass(BridgeMoveValue bridgeMoveValue) {
        List<String> up = isUp(bridgeMoveValue, WRONG);
        if (up != null) return up;

        return isDown(WRONG);
    }

    private static List<String> isUp(BridgeMoveValue bridgeMoveValue, String value) {
        if (bridgeMoveValue.equals(BridgeMoveValue.UP)) {
            return List.of(value, BLANK);
        }
        return null;
    }

    private static List<String> isDown(String value) {
        return List.of(BLANK, value);
    }
}
