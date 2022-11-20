package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static boolean moveWrongBlock;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean printMap(List<String> userPosition, List<String> bridge) {
        printUpBridge(userPosition, bridge);
        printDownBridge(userPosition, bridge);
        if(moveWrongBlock) {
            return false;
        }

        return true;
    }

    private static void printUpBridge(List<String> userPosition, List<String> bridge) {
        System.out.print("[ ");
        printBridge(userPosition, bridge, "U");
        System.out.println(" ]");

    }

    private static void printDownBridge(List<String> userPosition, List<String> bridge) {
        System.out.print("[ ");
        printBridge(userPosition, bridge, "D");
        System.out.println(" ]");
    }

    private static void printBridge(List<String> userPosition, List<String> bridge, String upDown) {
        for (int position = 0; position < userPosition.size(); position++) {
            boolean isPositionUpDown = userPosition.get(position).equals(upDown);
            boolean isBridgeUpDown = bridge.get(position).equals(upDown);

            splitBridge(position);
            printBlankOrOX(isPositionUpDown, isBridgeUpDown);
        }
    }

    private static void splitBridge(int position) {
        if (position != 0) {
            System.out.print(" | ");
        }
    }

    private static void printBlankOrOX(boolean isPositionUpDown, boolean isBridgeUpDown) {
        if (isPositionUpDown) {
            printOX(isBridgeUpDown);
        }
        if (!isPositionUpDown) {
            printBlank();
        }
    }

    private static void printOX(boolean isBridgeUpDown) {
        if (isBridgeUpDown) {
            System.out.print("O");
        }
        if (!isBridgeUpDown) {
            System.out.print("X");
            moveWrongBlock = true;
        }
    }

    private static void printBlank() {
        System.out.print(" ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
