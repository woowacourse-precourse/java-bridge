package bridge.view.iterator;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.validation.InputMoveValidator;
import bridge.vo.GameProgressMessage;

public class MoveInputIterator implements InputIterator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    @Override
    public String getInput() {
        String moveInput = "";
        do {
            outputView.printGameProgressMessage(GameProgressMessage.MOVE_MESSAGE);
            moveInput = input(moveInput);
        } while (moveInput.length() == 0);

        return moveInput;
    }

    public String input(String moveInput) {
        try {
            moveInput = inputView.readMoving();
            InputMoveValidator.validate(moveInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.getMessage());
            return "";
        }
        return moveInput;
    }
}
