package bridge.validation;

import bridge.convertor.InputConvertor;
import bridge.message.ErrorMessage;
import java.util.List;

public class InputValidation {
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final List<String> movePossibilityValue = List.of("U", "D");
    private static final List<String> tryPossibilityValue = List.of("Q", "R");


    public void bridgeSizeValidation(String value) {
        if (checkBridgeSize(convertInputToNumber(value))) {
            return;
        }

        System.out.println(ErrorMessage.BRIDGE_SIZE_ERROR);
        throw new IllegalArgumentException();
    }

    public void bridgeMoveValidation(String data) {
        if (checkMoveInputData(data)) {
            return;
        }

        System.out.println(ErrorMessage.INPUT_MOVE_ERROR);
        throw new IllegalArgumentException();
    }

    public void retryValidation(String data) {
        if (checkTryInputData(data)) {
            return;
        }

        System.out.println(ErrorMessage.INPUT_RETRY_ERROR);
        throw new IllegalArgumentException();
    }


    public int convertInputToNumber(String value) {
        try {
            return InputConvertor.inputParseNumber(value);
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }

    public boolean checkBridgeSize(int size) {
        return BRIDGE_MIN_SIZE <= size && size <= BRIDGE_MAX_SIZE;
    }

    public boolean checkMoveInputData(String data) {
        return movePossibilityValue.contains(data);
    }

    public boolean checkTryInputData(String data) {
        return tryPossibilityValue.contains(data);
    }
}
