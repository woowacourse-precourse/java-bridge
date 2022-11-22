package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int BRIDGE_SIZE_LOWER = 3;
    private static final int BRIDGE_SIZE_UPPER = 20;
    private static final String ERROR_NOT_NUMBER = "입력한 값이 숫자가 아닙니다.";
    private static final String ERROR_NOT_BRIDGE_SIZE = "다리 길이가 3 이상 20 이하가 아닙니다.";
    private static final String ERROR_NOT_READ_MOVING = "입력한 값이 U 또는 D가 아닙니다.";
    private static final String ERROR_NOT_GAME_COMMAND = "입력한 값이 R 또는 Q가 아닙니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String inputBridgeSize = Console.readLine();
            validBridgeSize(inputBridgeSize);
            return Integer.parseInt(inputBridgeSize);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    private void validBridgeSize(String inputBridgeSize) {
        validIsNumber(inputBridgeSize);
        validBridgeSizeInRange(Integer.parseInt(inputBridgeSize));
    }

    private void validIsNumber(String number) {
        boolean check = number.chars()
                .allMatch(Character::isDigit);

        if (!check) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void validBridgeSizeInRange(int number) {
        if (BRIDGE_SIZE_LOWER > number || number > BRIDGE_SIZE_UPPER) {
            throw new IllegalArgumentException(ERROR_NOT_BRIDGE_SIZE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String inputReadMoving = Console.readLine();
            validReadMoving(inputReadMoving);
            return inputReadMoving;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readMoving();
        }
    }

    private void validReadMoving(String inputReadMoving) {
        if (!inputReadMoving.matches("^[D|U]$")) {
            throw new IllegalArgumentException(ERROR_NOT_READ_MOVING);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String gameCommand = Console.readLine();
            validReadGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readGameCommand();
        }
    }

    private void validReadGameCommand(String gameCommand) {
        if (!gameCommand.matches("^[R|Q]$")) {
            throw new IllegalArgumentException(ERROR_NOT_GAME_COMMAND);
        }
    }
}
