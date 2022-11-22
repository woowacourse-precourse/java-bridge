package bridge.view;

// 패키지 변경 가능
// 메서드의 이름 변경 불가
// 메서드의 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
// 값 출력을 위해 필요한 메서드 추가 가능

import bridge.BridgeGame;

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
        printInFormat(upBridge);
        printInFormat(downBridge);
    }

    public void printInFormat(List<String> ox) {
        System.out.print("[ ");
        for (int i = 0; i < ox.size(); i++) {
            System.out.print(ox.get(i));
            if (i != ox.size() - 1)
                System.out.print(" | ");
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, int attempts) {

        System.out.println("최종 게임 결과");
        printMap(bridgeGame.upBridge, bridgeGame.downBridge);
        System.out.println("게임 성공 여부: " + bridgeGame.isSuccess().getKorean());
        System.out.println("총 시도한 횟수: " + attempts);
    }
}
