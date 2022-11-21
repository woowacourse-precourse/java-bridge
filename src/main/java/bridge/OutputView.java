package bridge;

import bridge.domain.BridgeGame;

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
    public void printMap(List<String> bridge, List<String> player) {
        printUpperBridge(bridge, player);
        printLowwerBridge(bridge, player);
        System.out.println();
    }
    private void printUpperBridge(List<String> bridge, List<String> player) {
        System.out.print("[");
        for (int i = 0; i < player.size(); i++) {
            printUpperBridgeStatus(bridge.get(i), player.get(i));
            if (i != (player.size() - 1)) {
                System.out.print("|");
            }
        }
        System.out.print("]\n");
    }

    private void printUpperBridgeStatus(String bridgeStatus, String playerMovement) {
        if (bridgeStatus.equals("U") && bridgeStatus.equals(playerMovement)) {
            System.out.print(" O ");
            return;
        }
        if (bridgeStatus.equals("U") && !bridgeStatus.equals(playerMovement)) {
            System.out.print(" X ");
            return;
        }
        System.out.print("   ");
    }

    private void printLowwerBridge(List<String> bridge, List<String> player) {
        System.out.print("[");
        for (int i = 0; i < player.size(); i++) {
            printLowerBridgeStatus(bridge.get(i), player.get(i));
            if (i != (player.size() - 1)) {
                System.out.print("|");
            }
        }
        System.out.print("]\n");
    }

    private void printLowerBridgeStatus(String bridgeStatus, String playerMovement) {
        if (bridgeStatus.equals("D") && bridgeStatus.equals(playerMovement)) {
            System.out.print(" O ");
            return;
        }
        if (bridgeStatus.equals("D") && !bridgeStatus.equals(playerMovement)) {
            System.out.print(" X ");
            return;
        }
        System.out.print("   ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
        printSuccessOrFail(bridgeGame);
        System.out.println("시도 횟수");
    }

    private void printSuccessOrFail(BridgeGame bridgeGame) {
        if(bridgeGame.isEnd()) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }
}
