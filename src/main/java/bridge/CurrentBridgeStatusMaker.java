package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeStatusMaker {

    private static final int DOWN = 0;
    private static final int UP = 1;
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
        currentBridgeStatus.add(new StringBuilder("["));
        currentBridgeStatus.add(new StringBuilder("["));
    }

    private void compare(String currentPlayerPosition, String playerEqualPosition) {
        if(currentPlayerPosition.equals(playerEqualPosition)) {
            markBridge(currentPlayerPosition, "O");
            return;
        }

        markBridge(currentPlayerPosition, "X");
    }

    private void makeEndPartBridge() {
        updateUpBridge("]");
        updateDownBridge("]");
    }

    private void updateUpBridge(String add) {
        StringBuilder upBridge = currentBridgeStatus.get(UP);

        if(add.equals("]")) {
            upBridge.replace(upBridge.length() - 1, upBridge.length(), add);
            return;
        }

        upBridge.append(add);
    }

    private void updateDownBridge(String add) {
        StringBuilder downBridge = currentBridgeStatus.get(DOWN);

        if(add.equals("]")) {
            downBridge.replace(downBridge.length() - 1, downBridge.length(), add);
            return;
        }

        downBridge.append(add);
    }

    void markBridge(String currentPlayerPosition, String mark) {
        if(currentPlayerPosition.equals("U")) {
            updateUpBridge(" " + mark + " |");
            updateDownBridge("   |");
            return;
        }

        updateUpBridge("   |");
        updateDownBridge(" " + mark + " |");
    }

}
