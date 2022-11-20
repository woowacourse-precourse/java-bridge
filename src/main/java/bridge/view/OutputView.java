package bridge.view;


import bridge.constant.OutputViewConstants;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String bridgeMapFormat) {
        System.out.printf(bridgeMapFormat);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String bridgeMapFormat, String successOrNot, int numberOfAttempts) {
        System.out.println(OutputViewConstants.FINAL_GAME_RESULT);
        printMap(bridgeMapFormat);
        System.out.println(OutputViewConstants.GAME_SUCCESS_OR_NOT + successOrNot);
        System.out.println(OutputViewConstants.TOTAL_NUMBER_OF_ATTEMPTS + numberOfAttempts + "\n");

    }

    public static void printGameStart() {
        System.out.println(OutputViewConstants.GAME_START_NOTICE);
    }

    static void printBridgeLengthRequest() {
        System.out.println();
        System.out.println(OutputViewConstants.BRIDGE_LENGTH_REQUEST);
    }

    static void printMovingRequest() {
        System.out.println(OutputViewConstants.MOVING_REQUEST);
    }

    static void printRestryRequest() {
        System.out.println(OutputViewConstants.RETRY_REQUEST);
    }
}
