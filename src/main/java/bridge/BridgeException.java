package bridge;

import view.InputView;

public class BridgeException {
    private final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public int bridgeSizeInputException() {
        try {
            int size = new InputView().readBridgeSize();
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(BRIDGE_SIZE_INPUT_ERROR);
            new BridgeController().makeBridgeController();
        }
        throw new IllegalArgumentException();
    }
}
