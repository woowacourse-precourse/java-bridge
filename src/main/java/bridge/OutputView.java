package bridge;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printMap(BridgeGame bridgeGame) {
        List<String> currentBridge = bridgeGame.getCurrentBridge();
        List<String> upperRow = convertUpperRow(currentBridge);
        List<String> lowerRow = convertLowerRow(currentBridge);
        System.out.println(addDelimiter(upperRow));
        System.out.println(addDelimiter(lowerRow));
    }

    public List<String> convertUpperRow(List<String> currentBridge) {
        List<String> upperRow = new ArrayList<>();
        for (String bridge : currentBridge) {
            if (bridge.equals(Constant.UP)) {
                upperRow.add(Constant.BRIDGE_RIGHT);
                continue;
            }
            upperRow.add(Constant.BRIDGE_WRONG);
        }
        return upperRow;
    }

    public List<String> convertLowerRow(List<String> currentBridge) {
        List<String> lowerRow = new ArrayList<>();
        for (String bridge : currentBridge) {
            if (bridge.equals(Constant.UP)) {
                lowerRow.add(Constant.BRIDGE_WRONG);
                continue;
            }
            lowerRow.add(Constant.BRIDGE_RIGHT);
        }
        return lowerRow;
    }

    public String addDelimiter(List<String> row) {
        return Constant.BRIDGE_START + String.join(Constant.BRIDGE_DELIMITER, row) + Constant.BRIDGE_END;
    }


    public void printResult() {
    }
}
