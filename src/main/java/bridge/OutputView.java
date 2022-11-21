package bridge;

import java.util.List;

public class OutputView {
    private static final String bridgeStart = "[ ";
    private static final String bridgeEnd = " ]";
    private static final String bridgeSection = " | ";

    public static void printMap(List<List<String>> currentBridge) {
        for (int printBridgeRow = 0; printBridgeRow < currentBridge.size(); printBridgeRow++) {
            System.out.print(bridgeStart);
            for (int printBridgeColumn = 0; printBridgeColumn < currentBridge.get(printBridgeRow).size(); printBridgeColumn++) {
                printMapWithSection(printBridgeColumn, currentBridge.get(printBridgeRow).get(printBridgeColumn));
            }
            System.out.println(bridgeEnd);
        }
    }

    public static void printMapWithSection(int printBridgeColumn, String bridge) {
        if (printBridgeColumn == 0) {
            System.out.print(bridge);
        }
        if (printBridgeColumn != 0) {
            System.out.print(bridgeSection + bridge);
        }
    }

    public void printResult() {
    }
}
