package bridge.utils;

import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class FirstInstanceBuilder {

    public static OXBridge buildOXBridge() {
        return OXBridge.from();
    }

    public static Bridge buildAnswerBridge(int inputSize) {
        return Bridge.of(inputSize);
    }

    public static int makeInputNum(String inputSize) {
        try {
            InputChecker.nullCheck(inputSize);
            return Integer.parseInt(inputSize.trim());
        } catch (IllegalArgumentException NE) {
            (new OutputView()).printSizeInputException();
            return (new InputView()).readBridgeSize();
        }
    }
}
