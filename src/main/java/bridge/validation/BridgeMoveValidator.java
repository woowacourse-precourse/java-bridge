package bridge.validation;

import bridge.resource.ErrorMessage;
import bridge.resource.GameConstant;
import bridge.view.InputView;
import java.util.List;

public class BridgeMoveValidator {
    private static final List<String> movePossibilityValue = List.of(GameConstant.TOP, GameConstant.BOTTOM);
    private static final InputView INPUT_VIEW = new InputView();

    public String moveValidator() {
        try {
            String input = INPUT_VIEW.readMoving();
            bridgeMoveValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return moveValidator();
        }
    }

    private void bridgeMoveValidation(String data) {
        if (checkMoveInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MOVE_ERROR);
    }


    public boolean checkMoveInputData(String data) {
        return movePossibilityValue.contains(data);
    }


}
