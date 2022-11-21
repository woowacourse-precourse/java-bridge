package bridge.View;

import bridge.Utils.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView extends OutputView {

    private final Validation validate;

    public InputView() {
        validate = new Validation();
        start();
    }

    public int readBridgeSize() {
        printGetUserBridgeSize();
        String inputSize = Console.readLine();

        try {
            return validate.checkSizeReturnInt(inputSize);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        printGetUserDirection();
        String direction = Console.readLine();

        try {
            validate.checkProperDirection(direction);
            return direction;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        printGetUserRetry();
        String retryInput = Console.readLine();

        try {
            validate.checkGameCommandInput(retryInput);
            return retryInput;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
