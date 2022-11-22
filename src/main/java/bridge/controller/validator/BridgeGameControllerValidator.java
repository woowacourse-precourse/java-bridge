package bridge.controller.validator;

import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameControllerValidator {

    private static final String IS_NOT_NULL = "null 이 올 수 없습니다";

    public static void validate(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker){
        validateInputView(inputView);
        validateOutputView(outputView);
        validateBridgeMaker(bridgeMaker);
    }

    private static void validateInputView(final InputView inputView) {
        if (inputView == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }

    private static void validateOutputView(final OutputView outputView) {
        if (outputView == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }

    private static void validateBridgeMaker(final BridgeMaker bridgeMaker) {
        if (bridgeMaker == null) {
            throw new IllegalArgumentException(IS_NOT_NULL);
        }
    }
}
