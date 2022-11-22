package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final int GAME_FAIL = 0;
    private static final int GAME_SUCCESS = 1;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param side
     */
    public void printMap(List<List<String>> side) {
        System.out.println("[ " + String.join(" | ", side.get(0)) + " ]");
        System.out.println("[ " + String.join(" | ", side.get(1)) + " ]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param finalState
     */
    public void printResult(List<List<String>> finalState, int gameResult, int gameCount) {
        System.out.println("최종 게임 결과");
        System.out.println("[ " + String.join(" | ", finalState.get(0)) + " ]");
        System.out.println("[ " + String.join(" | ", finalState.get(1)) + " ]");
        System.out.println();
        printGameResultAndGameCount(gameResult, gameCount);
    }

    private void printGameResultAndGameCount(int gameResult, int gameCount) {
        if (gameResult == GAME_SUCCESS) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + gameCount);
        }
        if (gameResult == GAME_FAIL) {
            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + gameCount);
        }
    }
}
