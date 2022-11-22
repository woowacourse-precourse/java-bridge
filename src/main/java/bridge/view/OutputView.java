package bridge.view;

import bridge.controller.BridgeGame;
import bridge.model.LowerBridge;
import bridge.model.UpperBridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(UpperBridge upperBridge, LowerBridge lowerBridge) {
        final String joinUpperBridge = String.join(" | ",upperBridge.upperStatus);
        final String joinLowerBridge = String.join(" | ",lowerBridge.lowerStatus);
        System.out.printf("[ %s ]\n",joinUpperBridge);
        System.out.printf("[ %s ]\n",joinLowerBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String successOrFail, UpperBridge upperBridge, LowerBridge lowerBridge) {
        System.out.println("최종 게임 결과");
        printMap(upperBridge, lowerBridge);
        System.out.println();
        System.out.printf("게임 성공 여부: %s\n",successOrFail);
        System.out.printf("총 시도한 횟수: %s\n", BridgeGame.allTryCount);
    }
}
