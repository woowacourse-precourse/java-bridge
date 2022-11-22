package bridge.view;


import bridge.domain.Bridge;

import java.util.List;

import static bridge.util.Notice.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> subBridges) {
        for (String subBridge : subBridges) {
            System.out.println(subBridge);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean finalResult, int attempts) {
        System.out.println(GAME_RESULT.of(finalResult));
        System.out.println(TOTAL_ATTEMPTS.of(attempts));
    }

    public void printFinalMap(List<Bridge> bridges) {
        System.out.println(FINAL_GAME_RESULT.of());
        for (Bridge bridge : bridges) {
            System.out.println(bridge.getBridge());
        }
    }
}
