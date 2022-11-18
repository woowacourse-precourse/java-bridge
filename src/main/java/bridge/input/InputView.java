package bridge.input;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    BridgeInput input;
    BridgeInputValidator validator;

    public InputView(BridgeInput input, BridgeInputValidator validator) {
        this.input = input;
        this.validator = validator;
    }

    public int readBridgeSize() {
        String inputSize = input.readData();

        while (!validator.validateBridgeSize(inputSize)) {
            inputSize = input.readData();
        }

        return parseInt(inputSize);
    }

    public char readMoving() {
        String inputMove = input.readData();

        while (!validator.validateMoveCommand(inputMove)) {
            inputMove = input.readData();
        }

        return convertFirstToChar(inputMove);
    }

    public char readGameCommand() {
        String inputCommand = input.readData();

        while (!validator.validateGameCommand(inputCommand)) {
            inputCommand = input.readData();
        }

        return convertFirstToChar(inputCommand);
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }

    private char convertFirstToChar(String str) {
        return str.charAt(0);
    }
}
