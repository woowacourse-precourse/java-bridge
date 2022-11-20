package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        // 다리 윗줄 출력
        printBridge(upBridge);
        // 다리 아랫줄 출력
        printBridge(downBridge);
    }

    private void printBridge(List<String> bridge) {
        System.out.print("[ ");

        for (int i = 0; i < bridge.size(); i++) {
            if (i == bridge.size() - 1) {
                System.out.print(bridge.get(i));
            }

            if (i < bridge.size() - 1) {
                System.out.print(bridge.get(i) + " | ");
            }
        }

        System.out.print(" ]\n");

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printResult(BridgeGame bridgeGame, int bridgeSize, int count, String game) {
        if (bridgeGame.getBridgeCount() == bridgeSize) {
            System.out.println("최종 게임 결과");
            printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + count);
            return "E";
        }
        return "R";
    }
}
