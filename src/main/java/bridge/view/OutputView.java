package bridge.view;

import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<List<String>> map = bridgeGame.getMap();
        List<String> upSideBridge = map.get(0);
        List<String> downSideBridge = map.get(1);

        printBridge(upSideBridge);
        printBridge(downSideBridge);
        System.out.println();
    }
    private void printBridge(List<String> bridge) {
        System.out.print("[");
        for (int i = 0; i < bridge.size(); i++) {
            System.out.print(" " + bridge.get(i) + " ");
            if (i != (bridge.size() - 1)) {
                System.out.print("|");
            }
        }
        System.out.print("]\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        printSuccessOrFail(bridgeGame);
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    private void printSuccessOrFail(BridgeGame bridgeGame) {
        if(bridgeGame.isEnd()) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }
}
