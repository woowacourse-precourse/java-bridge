package bridge.domain;

import bridge.view.Error;

public class BridgeMoveStatus {

    private final String inputMoving;

    private BridgeMoveStatus(String inputMoving) {
        this.inputMoving = inputMoving;
    }

    public static BridgeMoveStatus createMoving(String inputMoving) {
        validateMoving(inputMoving);

        return new BridgeMoveStatus(inputMoving);
    }

    private static void validateMoving(String inputMoving) {
        if (isEmptyInformation(inputMoving) || !isUpDownInformation(inputMoving)) {
            throw new IllegalArgumentException(Error.INPUT_MOVING_INFORMATION_ERROR.getMessage());
        }
    }

    private static boolean isEmptyInformation(String inputMoving) {
        return inputMoving.isEmpty();
    }

    private static boolean isUpDownInformation(String inputMoving) {
        return inputMoving.equals(BridgeMapper.UP.getUpDownInformation())
                || inputMoving.equals(BridgeMapper.DOWN.getUpDownInformation());
    }

    public String getMovingStatus() {
        return this.inputMoving;
    }
}
