package bridge;

import view.InputView;

public class BridgeException {
    private final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String MOVE_SIDE_INPUT_ERROR = "[ERROR] 이동할 칸 입력은 U 또는 D여야 합니다.";
    private final String RETRY_COMMAND_INPUT_ERROR = "[ERROR] 게임 재시작 여부를 위한 입력은 R 또는 Q여야 합니다.";

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
            System.out.println(MOVE_SIDE_INPUT_ERROR);
            new BridgeController().moveController();
            return false;
        }
        return true;
    }

    public void isCommandUOrD(String sideToMove) {
        if (!sideToMove.equals("U") && !sideToMove.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public String retryException(String retryCommand) {
        try {
            isCommandROrQ(retryCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(RETRY_COMMAND_INPUT_ERROR);
            retryCommand = new InputView().readGameCommand();
            retryCommand = retryException(retryCommand);
            return retryCommand;
        }
        return retryCommand;
    }

    public void isCommandROrQ(String retryCommand) {
        if (!retryCommand.equals("R") && !retryCommand.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}