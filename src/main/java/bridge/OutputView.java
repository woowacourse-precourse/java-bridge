package bridge;

import java.util.List;

public class OutputView {

    public void printMap(List<Integer> upperBridge, List<Integer> bottomBridge) {

        System.out.println("\n");

    }

    public void printResult() {
    }

    private void upperBridgeMap(List<Integer> upperBridge) {
        System.out.println("[ ");
        for (int i = 0; i < upperBridge.size(); i++) {
            printBridgeUnit(upperBridge.indexOf(i));
            if ((i != 0) && (i != upperBridge.size() - 1)) {
                System.out.println(" | ");
            }
        }
        System.out.println(" ]");
    }

    private void bottomBridgeMap(List<Integer> bottomBridge) {
        System.out.println("[ ");
        for (int i = 0; i < bottomBridge.size(); i++) {
            printBridgeUnit(bottomBridge.indexOf(i));
            if ((i != 0) && (i != bottomBridge.size() - 1)) {
                System.out.println(" | ");
            }
        }
        System.out.println(" ]");
    }

    private void printBridgeUnit(Integer bridgeUnit) {
        if (!printStatus(bridgeUnit)){
            skipBridgeUnit(bridgeUnit);
        }
    }

    private void skipBridgeUnit(Integer bridgeUnit) {
        if (bridgeUnit == 0) {
            System.out.println(" ");
        }
    }

    private Boolean printStatus(Integer bridgeUnit) {
        if (bridgeUnit == 1) {
            System.out.println("O");
        }
        if (bridgeUnit == 2) {
            System.out.println("X");
        }
        return ((bridgeUnit == 1) || (bridgeUnit == 2));
    }
}
