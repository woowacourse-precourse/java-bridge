package bridge.view;

import bridge.utils.constants.GameConstants;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStart() {
        System.out.println(GameConstants.START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String bridge) {
        System.out.println(bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String bridge, boolean gameResult, int gameCount) {
        System.out.println(GameConstants.GAME_RESULT);
        System.out.println(bridge);

        if (gameResult) {
            System.out.println(GameConstants.SUCCESS_GAME);
        }
        if (!gameResult) {
            System.out.println(GameConstants.FAIL_GAME);
        }
        System.out.printf(GameConstants.GAME_TRY_COUNT, gameCount);
    }
}
