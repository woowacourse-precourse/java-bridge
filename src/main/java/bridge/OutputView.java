package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeMoved, int currentPosition) {
        int bridgeSize = currentPosition;

        printBridgeUpper(bridgeMoved, bridgeSize);
        printBridgeLower(bridgeMoved, bridgeSize);
    }

    private void printBridgeUpper(List<String> bridgeMoved, int bridgeSize) {
        System.out.print("[");

        for (int idx = 0; idx < bridgeSize - 1; idx++) {
            System.out.print(moveBridge(bridgeMoved, idx, "U"));
            System.out.print("|");
        }
        System.out.print(moveBridge(bridgeMoved, bridgeSize - 1, "U"));

        System.out.print("]\n");
    }

    private void printBridgeLower(List<String> bridgeMoved, int bridgeSize) {
        System.out.print("[");

        for (int idx = 0; idx < bridgeSize - 1; idx++) {
            System.out.print(moveBridge(bridgeMoved, idx, "D"));
            System.out.print("|");
        }
        System.out.print(moveBridge(bridgeMoved, bridgeSize - 1, "D"));

        System.out.print("]\n");
    }

    private String moveBridge(List<String> bridgeMoved, int idx, String moveTo) {
        if (bridgeMoved.get(idx).equals(moveTo)) {
            return " O ";
        }
        return "   ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
