package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeStatusMaker {

    private static final int UP_INDEX = 1;
    private static final int DOWN_INDEX = 0;
    private List<StringBuilder> currentBridgeStatus;

    public List<StringBuilder> convertCurrentBridgeStatus(List<String> currentPlayerBridge, List<String> createdBridge) {
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
        if(currentPlayerPosition.equals(playerEqualPosition)) {
            markBridge(currentPlayerPosition, BridgeDrawing.O);
            return;
        }

        markBridge(currentPlayerPosition, BridgeDrawing.X);
    }

    private void makeEndPartBridge() {
        updateUpBridge(BridgeDrawing.BRIDGE_END_DRAWING.toString());
        updateDownBridge(BridgeDrawing.BRIDGE_END_DRAWING.toString());
    }

    private void updateUpBridge(String add) {
        StringBuilder upBridge = currentBridgeStatus.get(UP_INDEX);

        if(add.equals(BridgeDrawing.BRIDGE_END_DRAWING.toString())) {
            upBridge.replace(upBridge.length() - 1, upBridge.length(), add);
            return;
        }

        upBridge.append(add);
    }

    private void updateDownBridge(String add) {
        StringBuilder downBridge = currentBridgeStatus.get(DOWN_INDEX);

        if(add.equals(BridgeDrawing.BRIDGE_END_DRAWING.toString())) {
            downBridge.replace(downBridge.length() - 1, downBridge.length(), add);
            return;
        }

        downBridge.append(add);
    }

    void markBridge(String currentPlayerPosition, BridgeDrawing bridgeDrawing) {
        if(currentPlayerPosition.equals(StepDirectionCommand.U.toString())) {
            updateUpBridge(String.format(BridgeDrawing.BRIDGE_STEP_DRAWING.toString(), bridgeDrawing.toString()));
            updateDownBridge(BridgeDrawing.BRIDGE_NO_STEP_DRAWING.toString());
            return;
        }

        updateUpBridge(BridgeDrawing.BRIDGE_NO_STEP_DRAWING.toString());
        updateDownBridge(String.format(BridgeDrawing.BRIDGE_STEP_DRAWING.toString(), bridgeDrawing.toString()));
    }

}
