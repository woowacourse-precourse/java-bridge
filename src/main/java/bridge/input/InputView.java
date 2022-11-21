package bridge.input;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    BridgeInput input;
    BridgeValidator validator;

    public InputView(BridgeInput input, BridgeValidator validator) {
        this.input = input;
        this.validator = validator;
    }

    public int readBridgeSize() {
        String inputSize = input.readData();
        try {
            validator.validateBridgeSize(inputSize);
        } catch (IllegalArgumentException argumentException) {
            return readBridgeSize();
        }
        return parseInt(inputSize);
    }

    public String readMoving() {
        String inputMove = input.readData();
        try {
            validator.validateMoveCommand(inputMove);
        } catch (IllegalArgumentException argumentException) {
            return readMoving();
        }
        return inputMove;
    }

    public String readGameCommand() {
        String inputCommand = input.readData();
        try {
            validator.validateGameCommand(inputCommand);
        } catch (IllegalArgumentException argumentException) {
            return readGameCommand();
        }
        return inputCommand;
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }

    private char convertFirstToChar(String str) {
        return str.charAt(0);
    }
}
