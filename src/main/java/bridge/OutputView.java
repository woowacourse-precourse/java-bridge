package bridge;

import java.util.List;

public class OutputView {

    public static void printMap(List<Integer> upperBridge, List<Integer> bottomBridge) {
        upperBridgeMap(upperBridge);
        bottomBridgeMap(bottomBridge);
    }

    public static void printResult(List<Integer> upperBridge, List<Integer> bottomBridge) {
        System.out.println("최종 게임 결과");
        printMap(upperBridge, bottomBridge);
        System.out.print("\n게임 성공 여부: ");
        checkFinalResult(upperBridge, bottomBridge);
        System.out.println("총 시도한 횟수: " + BridgeGame.tryCount);
    }

    private static void checkFinalResult(List<Integer> upperBridge, List<Integer> bottomBridge) {
        if (!(upperBridge.contains(0)) && !(bottomBridge.contains(0))) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }

    private static void upperBridgeMap(List<Integer> upperBridge) {
        System.out.print("[");
        for (int i = 0; i < upperBridge.size(); i++) {
            printBridgeUnit(upperBridge.get(i));
            if (i != (upperBridge.size() - 1)) {
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    private static void bottomBridgeMap(List<Integer> bottomBridge) {
        System.out.print("[");
        for (int i = 0; i < bottomBridge.size(); i++) {
            printBridgeUnit(bottomBridge.get(i));
            if (i != (bottomBridge.size() - 1)) {
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    private static void printBridgeUnit(Integer bridgeUnit) {
        if (!printStatus(bridgeUnit)){
            skipBridgeUnit(bridgeUnit);
        }
    }

    private static void skipBridgeUnit(Integer bridgeUnit) {
        if (bridgeUnit == 2) {
            System.out.print("   ");
        }
    }

    private static Boolean printStatus(Integer bridgeUnit) {
        if (bridgeUnit == 1) {
            System.out.print(" O ");
        }
        if (bridgeUnit == 0) {
            System.out.print(" X ");
        }
        return ((bridgeUnit == 1) || (bridgeUnit == 0));
    }
}
