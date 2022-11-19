package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgePlay {

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    private final ValidationUtil validationUtil = new ValidationUtil();

    public void play() {
        outputView.printStartMessage();
        int bridgeLength = getBridgeLength();
    }

    public int getBridgeLength() {
        String userInput = inputView.readBridgeLength();
        int bridgeLength = 0;
        try {
            bridgeLength = validationUtil.validateBridgeLength(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBridgeLength();
        }
        return bridgeLength;
    }
}
