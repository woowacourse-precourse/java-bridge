package bridge.View;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.OutputSystemMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String bridgeStatus) {
        System.out.println(bridgeStatus);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String gameResult, boolean isSuccess , int gameCount) {
        printOutputSystemMessage(OutputSystemMessage.GAME_RESULT_OUTPUT);
        System.out.println(gameResult);
        printGameSuccess(isSuccess);
        printGameCount(gameCount);
    }

    public static void printGameStart() {
        printOutputSystemMessage(OutputSystemMessage.GAME_START_OUTPUT);
    }

    public static void printOutputSystemMessage(OutputSystemMessage situation) {
        String message = OutputSystemMessage.getMessage(situation);
        System.out.println(message);
    }

    public static String getOutputSystemMessage(OutputSystemMessage situation) {
        return OutputSystemMessage.getMessage(situation);
    }

    public static void printGameSuccess(boolean isSuccess) {
        String result = BridgeResultType.getMessage(isSuccess); 
        String output = getOutputSystemMessage(OutputSystemMessage.GAME_SUCCESS_OUTPUT) + result;
        System.out.println(output);
    }

    public static void printGameCount(int gameCount) {
        String output = getOutputSystemMessage(OutputSystemMessage.RUN_GAME_NUMBER_OUTPUT) + gameCount;
        System.out.println(output);
    }
}
