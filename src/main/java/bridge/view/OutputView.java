package bridge.view;

import bridge.resource.PrintMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println(PrintMessage.START_MESSAGE.getValue());
        System.out.println();
        System.out.println(PrintMessage.START_BRIDGE_INPUT.getValue());
    }

    public void printMove() {
        System.out.println();
        System.out.println(PrintMessage.MOVE_BLOCK_MESSAGE.getValue());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String message) {
        System.out.println(message);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, String success, int attempt) {
        System.out.println();
        System.out.println(PrintMessage.FINAL_GAME_RESULT_MESSAGE.getValue());
        System.out.println(result);

        System.out.println();
        System.out.printf(PrintMessage.SUCCESS_OR_NOT_MESSAGE.getValue() + "\n", success);
        System.out.printf(PrintMessage.NUMBER_OF_ATTEMPTS.getValue() + "\n", attempt);
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printRetry() {
        System.out.println();
        System.out.println(PrintMessage.RETRY_MESSAGE.getValue());
    }
}
