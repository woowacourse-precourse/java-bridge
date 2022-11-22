package bridge.view.iterator;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.validation.BridgeLengthValidator;
import bridge.vo.GameProgressMessage;

public class BridgeLengthInputIterator implements InputIterator {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    @Override
    public String getInput() {
        String inputLength = "";
        do {
            outputView.printGameProgressMessage(GameProgressMessage.INPUT_BRIDGE_LENGTH_MESSAGE);
            inputLength = input(inputLength);
        } while (inputLength.length() == 0);

        return inputLength;
    }

    public String input(String inputLength) {
        try {
            inputLength = inputView.readBridgeSize();
            BridgeLengthValidator.validate(inputLength);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.getMessage());
            return "";
        }
        return inputLength;
    }
}
