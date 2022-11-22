package bridge.view;

import java.util.List;

public class TestInputView extends InputView {
    private int bridgeSize;
    private List<String> userInput;
    private int inputIdx;

    public TestInputView(int bridgeSize, List<String> userInput) {
        this.bridgeSize = bridgeSize;
        this.userInput = userInput;
        this.inputIdx = 0;
    }

    @Override
    public int readBridgeSize() {
        return bridgeSize;
    }

    @Override
    public String readMoving() {
        return userInput.get(inputIdx++);
    }

    @Override
    public String readGameCommand() {
        return userInput.get(inputIdx++);
    }
}
