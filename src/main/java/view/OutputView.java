package view;

import static constant.Message.*;

import bridge.Bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String movingResult) {
        System.out.println(movingResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, String result) {
        System.out.println(PRINT_GAME_RESULT);
        if (result.equals(SUCCESS)) {
            printMap(bridge.movingResultToString(SUCCESS));
            System.out.printf((PRINT_WHETHER_SUCCESS_OR_NOT) + "%n", SUCCESS);
            System.out.printf((TOTAL_NUMBERS_OF_ATTEMPTS) + "%n", bridge.getGameCount());
            return;
        }
        printMap(bridge.movingResultToString(FAILURE));
        System.out.printf((PRINT_WHETHER_SUCCESS_OR_NOT) + "%n", FAILURE);
        System.out.printf((TOTAL_NUMBERS_OF_ATTEMPTS) + "%n", bridge.getGameCount());
    }

    public void printStartMessage() {
        System.out.println(PRINT_START_MESSAGE);
    }
}
