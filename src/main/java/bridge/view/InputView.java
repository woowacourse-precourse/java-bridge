package bridge.view;

import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.util.Constant.*;

public class InputView {

    public static int readBridgeSize() {
        OutputView.printInputBridgeSizeMessage();
        int result = BRIDGE_SIZE_INPUT_RETRY_POINT;
        while (result == BRIDGE_SIZE_INPUT_RETRY_POINT) {
            result = retryBridgeSizeInput();
        }
        return result;
    }

    private static int retryBridgeSizeInput() {
        try {
            String inputSize = Console.readLine();
            Validator.validateInputBridgeSizeType(inputSize);
            Validator.validateInputBridgeSizeRange(inputSize);
            return Integer.parseInt(inputSize);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
        return BRIDGE_SIZE_INPUT_RETRY_POINT;
    }

    public static String inputMoving() {
        OutputView.printMovingSelectMessage();
        String moveWord = BRIDGE_MOVE_INPUT_RETRY_POINT;
        while (moveWord.equals(BRIDGE_MOVE_INPUT_RETRY_POINT)) {
            moveWord = retryBridgeMoveInput();
        }
        return moveWord;
    }

    private static String retryBridgeMoveInput() {
        try {
            String moveCommandInput = Console.readLine();
            Validator.validateMovingWord(moveCommandInput);
            return moveCommandInput;
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
        return BRIDGE_MOVE_INPUT_RETRY_POINT;
    }



    public static String inputGameCommand() {
        String command = Console.readLine();
        Validator.validateGameCommand(command);
        return command;
    }
}
