package bridge.service;

import bridge.domain.result.BridgeResult;

public class BridgeGame {

    private final static String CORRECT = "O";
    private final static String WRONG = "X";
    private final BridgeResult resultBridge;

    public BridgeGame(BridgeResult resultBridge) {
        this.resultBridge = resultBridge;
    }

    public String move(String block, String blockToMove) {
        if (blockToMove.equals(block)) {
            resultBridge.addBlock(blockToMove, CORRECT);
            return CORRECT;
        }
        resultBridge.addBlock(blockToMove, WRONG);
        return WRONG;
    }

    public boolean retry(String command) {
        if (command.equals("R")) {
            return true;
        }
        return false;
    }

    public String getResultBridge() {
        return resultBridge.toString();
    }

    public void initialize() {
        resultBridge.clear();
    }

    public boolean completeCrossing(int bridgeSize) {
        if (bridgeSize == resultBridge.countCorrectCrossing()) {
            return true;
        }
        return false;
    }
}
