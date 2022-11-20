package bridge;

import constants.BridgeConstants;

import java.util.List;

public class BridgeFigureBuilder {

    private static final String START_OF_BRIDGE = "[ ";
    private static final String SEPARATE_OF_BRIDGE = " | ";
    private static final String END_OF_BRIDGE = " ]";
    private static final String EMPTY = " ";

    private final BridgeState bridgeState;
    private final StringBuilder upBridgeFigure = new StringBuilder();
    private final StringBuilder downBridgeFigure = new StringBuilder();

    public BridgeFigureBuilder(BridgeState bridgeState) {
        this.bridgeState = bridgeState;
    }

    @Override
    public String toString() {
        clearBridgeFigure();

        List<String> stateOfBridge = bridgeState.getStateOfBridge();
        List<String> directions = bridgeState.getDirections();

        makeStartOfBridgeFigure();
        makeMidOfBridgeFigure(stateOfBridge, directions);
        makeEndOfBridgeFigure();

        return upBridgeFigure.append('\n').append(downBridgeFigure).append('\n').toString();
    }

    private void clearBridgeFigure() {
        upBridgeFigure.delete(0, upBridgeFigure.length());
        downBridgeFigure.delete(0, downBridgeFigure.length());
    }

    private void makeStartOfBridgeFigure() {
        upBridgeFigure.append(START_OF_BRIDGE);
        downBridgeFigure.append(START_OF_BRIDGE);
    }

    private void makeMidOfBridgeFigure(List<String> stateOfBridge, List<String> directions) {
        for (int round = 0; round < stateOfBridge.size(); round++) {
            String currentDirection = directions.get(round);
            markAnswerOnBridge(stateOfBridge, round, currentDirection);

            if (round != stateOfBridge.size() - 1) {
                makeSeparateOfBridgeFigure();
            }
        }
    }

    private void markAnswerOnBridge(List<String> stateOfBridge, int round, String currentDirection) {
        if (currentDirection.equals(BridgeConstants.UP_DIRECTION)) {
            upBridgeFigure.append(stateOfBridge.get(round));
            downBridgeFigure.append(EMPTY);
        }
        if (currentDirection.equals(BridgeConstants.DOWN_DIRECTION)) {
            upBridgeFigure.append(EMPTY);
            downBridgeFigure.append(stateOfBridge.get(round));
        }
    }

    private void makeSeparateOfBridgeFigure() {
        upBridgeFigure.append(SEPARATE_OF_BRIDGE);
        downBridgeFigure.append(SEPARATE_OF_BRIDGE);
    }

    private void makeEndOfBridgeFigure() {
        upBridgeFigure.append(END_OF_BRIDGE);
        downBridgeFigure.append(END_OF_BRIDGE);
    }
}
