package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeInput = Console.readLine();
        return Integer.parseInt(bridgeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String playerMoving = Console.readLine();
        return playerMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String restartInput = Console.readLine();
        return restartInput;
    }

    public void bridgeSizeVerification(String bridgeLength) {
        validateNull(bridgeLength);
        validateNumber(bridgeLength);
        validateBetween(bridgeLength);
    }

    public void validateNull(String bridgeLength) {
        if (bridgeLength.equals(EMPTY_VALUE)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT);
        }
    }

    public void validateBetween(String bridgeLength) {
        int bridge = Integer.parseInt(bridgeLength);
        if (!(bridge >= STARTING_POINT_CONDITION && bridge <= LAST_POINT_CONDITION)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_BETWEEN);
        }
    }

    public void validateNumber(String bridgeLength) {
        if (!(bridgeLength.matches(REGULAR_PATTERN))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_CHARACTERS);
        }
    }

    public void udValidateCharacter(String playerMoving) {
        if (!(playerMoving.equals(Command.UP.getCommand()) || playerMoving.equals(
                Command.DOWN.getCommand()))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_UP_DOWN_CHARACTERS);
        }
    }

    public void rqValidateCharacter(String playerMoving) {
        if (!(playerMoving.equals(Command.RE_START.getCommand()) || playerMoving.equals(
                Command.END.getCommand()))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_RESTART_QEND_CHARACTERS);
        }
    }
}