package bridge;

import model.Bridge;

import java.util.Map;

public class OutputView {

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(Map<String, Bridge> bridges) {
        printBridge(bridges.get("upperBridge"));
        printBridge(bridges.get("lowerBridge"));
    }

    public void printResult(BridgeGame bridgeGame, Bridge bridge) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getMovedBridge());
        System.out.println();
        System.out.printf("게임 성공 여부: %s\n", bridgeGame.getResult(bridge));
        System.out.printf("총 시도한 횟수: %s", bridgeGame.getNumberOfRetry());
    }

    public void printBridge(Bridge bridge) {
        System.out.print("[");
        for (int index = 0; index < bridge.getSize(); index++) {
            if (index != 0) {
                System.out.print("|");
            }
            System.out.print(" " + bridge.getBridge(index) + " ");
        }
        System.out.println("]");
    }
}
