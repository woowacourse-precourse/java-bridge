package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeStatusMaker {

    private static final int DOWN = 0;
    private static final int UP = 1;
    private List<StringBuilder> currentBridgeStatus;

    public List<StringBuilder> convertCurrentBridgeStatus(List<String> currentPlayerBridge, List<String> createdBridge) {

        currentBridgeStatus = new ArrayList<>();
        currentBridgeStatus.add(new StringBuilder("["));
        currentBridgeStatus.add(new StringBuilder("["));

        for (int length = 0; length < currentPlayerBridge.size(); length++) {
            String currentPlayerPosition = currentPlayerBridge.get(length);
            String playerEqualPosition = createdBridge.get(length);

            if(currentPlayerPosition.equals(playerEqualPosition)) {
                markBridge(currentPlayerPosition, "O");
                continue;
            }

            markBridge(currentPlayerPosition, "X");
        }


        updateUpBridge("]");
        updateDownBridge("]");

        return currentBridgeStatus;
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
