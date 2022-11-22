package bridge.service;

import bridge.vo.BridgeDrawing;
import bridge.vo.StepDirectionCommand;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeStatusMaker {

    private static final int UP_INDEX = 1;
    private static final int DOWN_INDEX = 0;
    private List<StringBuilder> currentBridgeStatus;

    public List<StringBuilder> convertCurrentBridgeStatus(List<String> currentPlayerBridge,
                                                          List<String> createdBridge) {
        makeStartPartBridge();
        for (int length = 0; length < currentPlayerBridge.size(); length++) {
            compare(currentPlayerBridge.get(length), createdBridge.get(length));
        }
        makeEndPartBridge();

        return currentBridgeStatus;
    }

    private void makeStartPartBridge() {
        currentBridgeStatus = new ArrayList<>();
        currentBridgeStatus.add(new StringBuilder(BridgeDrawing.BRIDGE_START_DRAWING.toString()));
        currentBridgeStatus.add(new StringBuilder(BridgeDrawing.BRIDGE_START_DRAWING.toString()));
    }

    private void compare(String currentPlayerPosition, String playerEqualPosition) {
        if (currentPlayerPosition.equals(playerEqualPosition)) {
            markBridge(currentPlayerPosition, BridgeDrawing.O);
            return;
        }

        markBridge(currentPlayerPosition, BridgeDrawing.X);
    }

    private void makeEndPartBridge() {
        updateBridge(UP_INDEX, BridgeDrawing.BRIDGE_END_DRAWING.toString());
        updateBridge(DOWN_INDEX, BridgeDrawing.BRIDGE_END_DRAWING.toString());
    }

    private void updateBridge(int index, String partOfBridge) {
        StringBuilder bridgeLine = currentBridgeStatus.get(index);

        if (partOfBridge.equals(BridgeDrawing.BRIDGE_END_DRAWING.toString())) {
            bridgeLine.replace(bridgeLine.length() - 1, bridgeLine.length(), partOfBridge);
            return;
        }

        bridgeLine.append(partOfBridge);
    }

    private void markBridge(String currentPlayerPosition, BridgeDrawing bridgeDrawing) {
        String drawingBridge = getPartOfBridge(bridgeDrawing);
        if (currentPlayerPosition.equals(StepDirectionCommand.U.toString())) {
            updateBridge(UP_INDEX, drawingBridge);
            updateBridge(DOWN_INDEX, BridgeDrawing.BRIDGE_NO_STEP_DRAWING.toString());
            return;
        }
        updateBridge(UP_INDEX, BridgeDrawing.BRIDGE_NO_STEP_DRAWING.toString());
        updateBridge(DOWN_INDEX, drawingBridge);
    }

    private String getPartOfBridge(BridgeDrawing bridgeDrawing) {
        return String.format(BridgeDrawing.BRIDGE_STEP_DRAWING.toString(),
                bridgeDrawing.toString());
    }
}
