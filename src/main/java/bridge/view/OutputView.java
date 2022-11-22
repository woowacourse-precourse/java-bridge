package bridge.view;

// 패키지 변경 가능
// 메서드의 이름 변경 불가
// 메서드의 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
// 값 출력을 위해 필요한 메서드 추가 가능

import bridge.BridgeGame;

import java.util.List;

import static bridge.constant.PrintMessage.*;

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
        printBridgeInFormat(upBridge);
        printBridgeInFormat(downBridge);
        System.out.println("");
    }

    public void printBridgeInFormat(List<String> ox) {
        System.out.print(BRIDGE_OPEN);
        for (int i = 0; i < ox.size(); i++) {
            System.out.print(ox.get(i));
            if (i != ox.size() - 1)
                System.out.print(BRIDGE_BAR);
        }
        System.out.println(BRIDGE_CLOSE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, int attempts) {

        System.out.println(GAME_RESULT);
        printMap(bridgeGame.upBridge, bridgeGame.downBridge);
        System.out.println(SUCCESS_FAIL + bridgeGame.isSuccess().getKorean());
        System.out.println(ATTEMPTS_CNT + attempts);
    }
}
