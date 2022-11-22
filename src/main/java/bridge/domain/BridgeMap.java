package bridge.domain;

import bridge.utils.Setting;

public class BridgeMap {
    private static final String SEPARATOR = "|";
    private static final String CORRECT = " O ";
    private static final String INCORRECT = " X ";
    private static final String BLANK = "   ";

    private final BridgeGame bridgeGame;
    private final StringBuilder upperBridge = new StringBuilder();
    private final StringBuilder lowerBridge = new StringBuilder();

    public BridgeMap(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public StringBuilder getUpperBridge() {
        return upperBridge;
    }

    public StringBuilder getLowerBridge() {
        return lowerBridge;
    }

    public void makeMap(String direction) {
        int bridgeIndex = bridgeGame.getCurrentIndex();
        boolean isCorrect = bridgeGame.isGameContinue();
        makeUpperBridge(bridgeIndex, isCorrect, direction);
        makeLowerBridge(bridgeIndex, isCorrect, direction);
    }

    private void makeUpperBridge(int bridgeIndex, boolean isCorrect, String direction) {
        addSeparator(upperBridge, bridgeIndex);
        if (direction.equals(Setting.UPPER_BRIDGE)) {
            addStatus(upperBridge, isCorrect);
            return;
        }
        addBlank(upperBridge);
    }

    private void makeLowerBridge(int bridgeIndex, boolean isCorrect, String direction) {
        addSeparator(lowerBridge, bridgeIndex);
        if (direction.equals(Setting.LOWER_BRIDGE)) {
            addStatus(lowerBridge, isCorrect);
            return;
        }
        addBlank(lowerBridge);
    }

    private void addBlank(StringBuilder str) {
        str.append(BLANK);
    }

    private void addStatus(StringBuilder str, boolean isCorrect) {
        if (isCorrect) {
            str.append(CORRECT);
            return;
        }
        str.append(INCORRECT);
    }

    private void addSeparator(StringBuilder str, int bridgeIndex) {
        if (bridgeIndex != 0) {
            str.append(SEPARATOR);
        }
    }
}