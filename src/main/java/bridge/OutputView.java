package bridge;

import java.util.List;

import static bridge.OutputType.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(PRINT_GAME_START.getMessage());
    }

    public void printResultTitle() {
        System.out.println(PRINT_RESULT_TITLE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeMap) {
        for (List<String> bridge : bridgeMap) {
            System.out.println(String.format(PRINT_MAP_FRONT.getMessage(), bridge.get(0)));

            for (int i = 1; i < bridgeMap.size(); i++) {
                System.out.println(String.format(PRINT_MAP_MID.getMessage(), bridge.get(i)));
            }
            System.out.println(String.format(PRINT_MAP_BACK.getMessage()));
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int count) {
        System.out.println(String.format(PRINT_RESULT.getMessage(), result, count));
    }
}
