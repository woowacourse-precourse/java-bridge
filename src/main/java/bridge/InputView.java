package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;

    private OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            validateInputBridgeSize(input);
        } catch(IllegalArgumentException e) {
            outputView.printError(ExceptionMesssage.BRIDGE_SIZE_ERROR);
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        try {
            validateInputBridgeSide(input);
        } catch(IllegalArgumentException e) {
            outputView.printError(ExceptionMesssage.BRIDGE_MOVING_ERROR);
            return readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        try {
            validateInputGameCommand(input);
        } catch(IllegalArgumentException e) {
            outputView.printError(ExceptionMesssage.GAME_COMMAND_ERROR);
            return readGameCommand();
        }
        return input;
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputBridgeSize(String input) {
        validateInputIsNumber(input);
        int number = Integer.parseInt(input);

        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputBridgeSide(String input) {
        if(input.equals(BridgeSideType.UPPER_SIDE.getSide()) || input.equals(BridgeSideType.LOWER_SIDE.getSide())) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void validateInputGameCommand(String input) {
        if(input.equals(BridgeGameCommandType.RESTART.getGameCommand()) || input.equals(BridgeGameCommandType.QUIT.getGameCommand())) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
