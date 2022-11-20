package bridge.view;

import bridge.domain.Message;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printWelcome() {
        System.out.printf(Message.START_GAME.get());
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> bridgeMap) {
        for (int i = 0; i < 2; i ++) {
            System.out.printf("[");
            System.out.printf("%2s ", bridgeMap.get(i).get(0));
            for (int r = 1; r < bridgeMap.get(i).size(); r ++) {
                System.out.printf("|");
                System.out.printf("%2s ", bridgeMap.get(i).get(r));
            }
            System.out.printf("]\n");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
