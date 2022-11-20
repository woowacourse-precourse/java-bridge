package bridge.view;

import bridge.domain.Message;
import bridge.domain.bridge.BridgeMap;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printWelcome() {
        System.out.printf(Message.OUTPUT_START_GAME.get());
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> data) {
        for (int i = 0; i < 2; i ++) {
            List<String> line = data.get(i);
            System.out.printf("[");
            System.out.printf("%2s ", line.get(0));
            for (int r = 1; r < line.size(); r ++) {
                System.out.printf("|");
                System.out.printf("%2s ", line.get(r));
            }
            System.out.printf("]\n");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> mapData, boolean isSuccess, int tries) {
        System.out.printf(Message.OUTPUT_END_GAME.get());
        printMap(mapData);
        System.out.printf(Message.OUTPUT_STATUS.get(), isSuccess, tries);
    }
}
