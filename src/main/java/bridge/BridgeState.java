package bridge;

import constants.BridgeConstants;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {

    private static final String START_OF_BRIDGE = "[ ";
    private static final String SEPARATE_OF_BRIDGE = " | ";
    private static final String END_OF_BRIDGE = " ]";

    private final List<String> directions = new ArrayList<>();
    private final List<String> stateOfBridge = new ArrayList<>();
    private final StringBuilder upBridgeFigure = new StringBuilder();
    private final StringBuilder downBridgeFigure = new StringBuilder();

    public void updateStateOfBridge(String direction, String resultOfMoving) {
        directions.add(direction);
        stateOfBridge.add(resultOfMoving);
    }

    public void clearAllBridgeState() {
        directions.clear();
        stateOfBridge.clear();
    }

    @Override
    public String toString() {
        clearBridgeFigure();

        makeStartOfBridgeFigure();
        makeMidOfBridgeFigure();
        makeEndOfBridgeFigure();

        return upBridgeFigure.append('\n').append(downBridgeFigure).toString();
    }

    private void clearBridgeFigure() {
        upBridgeFigure.delete(0, upBridgeFigure.length());
        downBridgeFigure.delete(0, downBridgeFigure.length());
    }

    private void makeStartOfBridgeFigure() {
        upBridgeFigure.append(START_OF_BRIDGE);
        downBridgeFigure.append(START_OF_BRIDGE);
    }

    private void makeMidOfBridgeFigure() {
        for (int round = 0; round < stateOfBridge.size(); round++) {
            String currentDirection = directions.get(round);
            markAnswerOnBridge(round, currentDirection);

            if (round != stateOfBridge.size() - 1) {
                makeSeparateOfBridgeFigure();
            }
        }
    }

    private void markAnswerOnBridge(int round, String currentDirection) {
        if (currentDirection.equals(BridgeConstants.UP_DIRECTION)) {
            upBridgeFigure.append(stateOfBridge.get(round));
            downBridgeFigure.append(" ");
        }
        if (currentDirection.equals(BridgeConstants.DOWN_DIRECTION)) {
            upBridgeFigure.append(" ");
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
