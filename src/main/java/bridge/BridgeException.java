package bridge;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;

public class BridgeException {
    private final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String MOVE_SIDE_INPUT_ERROR = "[ERROR] 이동할 칸은 U 또는 D여야 합니다.";

    public int bridgeSizeInputException() {
        try {
            int size = new InputView().readBridgeSize();
            bridgeLengthException(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(BRIDGE_SIZE_INPUT_ERROR);
            new BridgeController().makeBridgeController();
        }
        throw new IllegalArgumentException();
    }

    public void bridgeLengthException(int size) {
        try {
            if (!isBridgeSize3To20(size)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(BRIDGE_SIZE_INPUT_ERROR);
            new BridgeController().makeBridgeController();
        }
    }

    public boolean isBridgeSize3To20(int size) {
        if (size >= 3 && size <= 20) {
            return true;
        }
        return false;
    }

    public boolean moveException(String sideToMove) {
        try {
            isCommandUOrD(sideToMove);
        } catch (IllegalArgumentException e) {
            System.out.println();
            new BridgeController().moveController();
            return false;
        }
        return true;
    }

    public void isCommandUOrD(String sideToMove) {
        if (!sideToMove.equals("U") && !sideToMove.equals("D")) {
            throw new IllegalArgumentException(MOVE_SIDE_INPUT_ERROR);
        }
    }
}