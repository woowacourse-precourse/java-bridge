package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.vo.PlayerMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PlayerMap playerMap) {
        for (List<String> playerMapLine : playerMap.getPlayerMap()) {
            System.out.print("[ ");
            printMiddleMap(playerMapLine);
            System.out.println(" ]");
        }
        System.out.println();
    }

    private void printMiddleMap(List<String> playerMap) {
        for (int index = 0; index < playerMap.size(); index++) {
            System.out.print(playerMap.get(index));
            if (index != playerMap.size() - 1) {
                System.out.print(" | ");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(PlayerMap playerMap, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(playerMap);
        System.out.println("게임 성공 여부: "+bridgeGame.getStatus());
        System.out.println("총 시도한 횟수: "+bridgeGame.getCount());
    }
}
