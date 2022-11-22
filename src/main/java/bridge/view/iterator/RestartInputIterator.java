package bridge.view.iterator;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.validation.InputRestartValidator;
import bridge.vo.GameProgressMessage;

public class RestartInputIterator implements InputIterator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    @Override
    public String getInput() {
        String retryInput = "";
        do {
            outputView.printGameProgressMessage(GameProgressMessage.GAME_RETRY_MESSAGE);
            retryInput = input(retryInput);
        } while (retryInput.length() == 0);

        return retryInput;
    }

    public String input(String retryInput) {
        try {
            retryInput = inputView.readGameCommand();
            InputRestartValidator.validate(retryInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.getMessage());
            return "";
        }
        return retryInput;
    }
}
