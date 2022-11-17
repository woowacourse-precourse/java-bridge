package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String size = Console.readLine();
        isValidBridgeSize(size);
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String moving = Console.readLine();
        isValidMove(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String gameCommand = Console.readLine();
        isValidRetryOrQuit(gameCommand);
        return gameCommand;
    }

    public void isValidBridgeSize(String size) throws IllegalArgumentException {
        isBridgeSizeNumber(size);
        isBridgeSizeValidRange(size);
    }

    public void isBridgeSizeNumber(String size) {
        if (!size.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(InputException.BRIDGE_SIZE_NOT_NUMBER.message());
        }
    }

    public void isBridgeSizeValidRange(String size) {
        if (3 > Integer.parseInt(size) || Integer.parseInt(size) > 20) {
            throw new IllegalArgumentException(InputException.BRIDGE_SIZE_INVALID_RANGE.message());
        }
    }

    public void isValidMove(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(InputException.MOVE_INVALID.message());
        }
    }

    public void isValidRetryOrQuit(String gameCommand) {
        if (!gameCommand.equals("Q") && !gameCommand.equals("R")) {
            throw new IllegalArgumentException(InputException.RETRY_OR_QUIT_INVALID.message());
        }
    }
}
