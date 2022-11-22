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

        List<String> markingsOfUserMoving = bridgeState.getMarkingsOfUserMoving();
        List<String> rightDirectionsOfBridge = bridgeState.getRightDirectionsOfBridge();

        makeStartOfBridgeFigure();
        makeMidOfBridgeFigure(markingsOfUserMoving, rightDirectionsOfBridge);
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

    private void makeMidOfBridgeFigure(List<String> markingsOfUserMoving, List<String> rightDirectionsOfBridge) {
        for (int round = 0; round < markingsOfUserMoving.size(); round++) {
            String currentDirection = rightDirectionsOfBridge.get(round);
            markAnswerOnBridge(markingsOfUserMoving, round, currentDirection);

            if (round != markingsOfUserMoving.size() - 1) {
                makeSeparateOfBridgeFigure();
            }
        }
    }

    private void markAnswerOnBridge(List<String> markingsOfUserMoving, int round, String currentDirection) {
        if (currentDirection.equals(BridgeConstants.UP_DIRECTION)) {
            upBridgeFigure.append(markingsOfUserMoving.get(round));
            downBridgeFigure.append(EMPTY);
        }
        if (currentDirection.equals(BridgeConstants.DOWN_DIRECTION)) {
            upBridgeFigure.append(EMPTY);
            downBridgeFigure.append(markingsOfUserMoving.get(round));
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
