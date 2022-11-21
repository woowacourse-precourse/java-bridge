package bridge;

import java.util.List;

import static bridge.Message.GuideMessage.*;

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

    public static void printResult(boolean isSuccess, int bridgeGameCount, List<List<String>> currentBridge) {
        System.out.println(GAME_RESULT_MESSAGE.getGuideMessage());
        printMap(currentBridge);
        System.out.print(GAME_SUCCESS_OR_NOT_MESSAGE.getGuideMessage());
        if (isSuccess) {
            System.out.println(GAME_SUCCESS_MESSAGE.getGuideMessage());
        }
        if (!isSuccess) {
            System.out.println(GAME_FAIL_MESSAGE.getGuideMessage());
        }
        System.out.println(TOTAL_GAME_COUNT_MESSAGE.getGuideMessage() + bridgeGameCount);
    }
}
