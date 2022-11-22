package bridge.view;

import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        String inputSize = Console.readLine();
        Validator.validateInputBridgeSizeType(inputSize);
        Validator.validateInputBridgeSizeRange(inputSize);
        return Integer.parseInt(inputSize);
    }

    public static String inputMoving() {
        OutputView.printMovingSelectMessage();
        String moveWord = Console.readLine();
        Validator.validateMovingWord(moveWord);
        return moveWord;
    }

    public static String inputGameCommand() {
        String command = Console.readLine();
        Validator.validateGameCommand(command);
        return command;
    }
}
