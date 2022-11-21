package bridge.controller;

import bridge.exception.ExceptionMessage;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void run() {
        try {
            String size = inputView.readBridgeSize();
            validateBridgeSize(size);

            int bridgeSize = Integer.parseInt(size);
            bridgeGame = new BridgeGame(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    // 검증 메서드
    public void validateBridgeSize(String size) {
        validateBridgeSizeIsNull(size);
        validateBridgeSizeIsNumeric(size);
        validateBridgeSizeRange(size);
    }

    public void validateBridgeSizeIsNull(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.BRIDGE_SIZE_IS_NULL_ERROR));
        }
    }

    public void validateBridgeSizeIsNumeric(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.BRIDGE_SIZE_IS_NOT_NUMBER_ERROR));
        }
    }

    public void validateBridgeSizeRange(String size) {
        int bridgeSize = Integer.parseInt(size);

        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.BRIDGE_SIZE_RANGE_ERROR));
        }
    }
}
