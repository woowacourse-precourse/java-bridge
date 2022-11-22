package bridge.ui;

import bridge.util.Commands;
import bridge.util.Results;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String upBridge, String downBridge) {
        printMessage(upBridge);
        printMessage(downBridge);
        printMessage(Commands.EMPTY_LINE.message());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isComplete, int attempts) {
        if (isComplete) {
            printMessage(Results.SUCCESS_OR_NOT.message(SUCCESS));
        }
        if (!isComplete) {
            printMessage(Results.SUCCESS_OR_NOT.message(FAIL));
        }
        printMessage(Results.NUMBER_OF_ATTEMPTS.message(Integer.toString(attempts)));
    }

    public void printStartMessage() {
        printMessage(Commands.START_MESSAGE.message());
        printMessage(Commands.EMPTY_LINE.message());
    }

    public void printMessage(String message) {
        System.out.print(message);
    }
}
