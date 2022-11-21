package bridge.validation;

import bridge.game.Player;
import bridge.resource.ErrorMessage;
import bridge.resource.GameConstant;
import bridge.view.OutputView;
import java.util.List;

public class BridgeMoveValidator {
    private static final List<String> movePossibilityValue = List.of(GameConstant.TOP, GameConstant.BOTTOM);

    public String moveValidator(String input) {
        try {
            bridgeMoveValidation(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return Player.requestInputMoveToValition();
        }
    }

    private void bridgeMoveValidation(String data) {
        if (checkMoveInputData(data)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MOVE_ERROR);
    }


    private boolean checkMoveInputData(String data) {
        return movePossibilityValue.contains(data);
    }


}
