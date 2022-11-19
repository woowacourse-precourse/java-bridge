package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        String size = inputView.readBridgeSize();
        validateBridgeSize(size);

        int bridgeSize = Integer.parseInt(size);

    }

    // 검증 메서드
    public void validateBridgeSize(String size) {
        validateBridgeSizeIsNull(size);
        validateBridgeSizeIsNumeric(size);
        validateBridgeSizeRange(size);
    }

    public void validateBridgeSizeIsNull(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("다리의 길이를 입력 해주세요");
        }
    }

    public void validateBridgeSizeIsNumeric(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리의 길이는 숫자만 가능합니다.");
        }
    }

    public void validateBridgeSizeRange(String size) {
        int bridgeSize = Integer.parseInt(size);

        if (bridgeSize < 3 && bridgeSize > 20) {
            throw new IllegalArgumentException("다리의 길이는 3 이상 20 이하의 정수이어야 합니다.");
        }
    }
}
