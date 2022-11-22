package bridge.view;

import bridge.exception.InputExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        OutputView.printGameStart();
        OutputView.inputBridgeSize();
        while (true) {
            try {
                return InputExceptionHandler.checkBridgeSize(Console.readLine());
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }

    public static String readMoving() {
        OutputView.inputMoveDirection();
        while (true) {
            try {
                return InputExceptionHandler.checkMovingCommand(Console.readLine());
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }

    public static String readGameCommand() {
        OutputView.inputGameRestart();
        while (true) {
            try {
                return InputExceptionHandler.checkRetryCommand(Console.readLine());
            } catch (IllegalStateException errorMESSAGE) {
                System.out.println(errorMESSAGE.getMessage());
            }
        }
    }
}

