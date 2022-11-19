package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, boolean isMoving) {
        List<List<String>> bridgeMap = drawSuccessBridge(bridge);
        if (!isMoving) {
            bridgeMap = drawFailedBridge(bridge);
        }
        System.out.println("[" + String.join(" | ", bridgeMap.get(0)) + "]");
        System.out.println("[" + String.join(" | ", bridgeMap.get(1)) + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private static List<List<String>> drawSuccessBridge(List<String> bridge) {
        List<List<String>> bridgeMap = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
        for (int i = 0; i < bridge.size() - 1; i++) {
            String cell = bridge.get(i);
            drawCorrectCell(bridgeMap, cell);
        }
        return bridgeMap;
    }

    private static List<List<String>> drawFailedBridge(List<String> bridge) {
        List<List<String>> successBridge = drawSuccessBridge(bridge);
        String lastCell = bridge.get(bridge.size() - 1);
        drawFailedCell(successBridge, lastCell);
        return successBridge;
    }

    private static void drawCorrectCell(List<List<String>> bridgeMap, String correctDirection) {
        List<String> upperRow = bridgeMap.get(0);
        List<String> lowerRow = bridgeMap.get(1);
        if (correctDirection.equals("U")) {
            upperRow.add("O");
            lowerRow.add(" ");
        }
        if (correctDirection.equals("D")) {
            lowerRow.add("O");
            upperRow.add(" ");
        }
    }

    private static void drawFailedCell(List<List<String>> bridgeMap, String correctDirection) {
        List<String> upperRow = bridgeMap.get(0);
        List<String> lowerRow = bridgeMap.get(1);
        if (correctDirection.equals("U")) {
            upperRow.add(" ");
            lowerRow.add("X");
        }
        if (correctDirection.equals("D")) {
            lowerRow.add(" ");
            upperRow.add("X");
        }
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
