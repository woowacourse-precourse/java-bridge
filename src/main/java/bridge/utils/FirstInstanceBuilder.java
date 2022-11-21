package bridge.utils;

import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class FirstInstanceBuilder {

    public static OXBridge buildOXBridge() {
        return OXBridge.from();
    }

    public static Bridge buildAnswerBridge(String inputSize, InputView inputView, OutputView outputView) {
        try {
            return makeBridgeInstance(inputSize, inputView, outputView);
        } catch (IllegalArgumentException e) {
            outputView.printSizeInputException();
            return buildAnswerBridge(inputView.readBridgeSize(), inputView, outputView);
        }
    }

    public static Bridge makeBridgeInstance(String inputSize, InputView inputView, OutputView outputView) {
        InputChecker.nullCheck(inputSize);
        try {
            return Bridge.of(Integer.parseInt(inputSize.trim()));
        } catch (NumberFormatException e) {
            outputView.printSizeInputException();
            return buildAnswerBridge(inputView.readBridgeSize(), inputView, outputView);

        }
    }
}
