package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_SIZE_NUMBER = "[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.";
    private static final String ERROR_SIZE_CHAR = "[ERROR] 다리의 길이는 숫자만 입력 가능합니다.";
    private static final String ERROR_MOVE_DIRECTION = "[ERROR] 이동 방향은 위(U), 아래(D)만 가능합니다.";
    private static final String ERROR_GAME_COMMAND = "[ERROR] 재시작은 R, 종료는 Q 입니다.";
    private static final String REGEX = "[0-9]+";
    private static final String UP_DIRECTION = "U";
    private static final String DOWN_DIRECTION = "D";
    private static final String RESTART = "R";
    private static final String EXIT = "Q";
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private static String bridgeSize;
    private static String moveDirection;
    private static String gameCommand;

    public int readBridgeSize() {
        bridgeSize = Console.readLine();
        try {
            validateSizeChar(bridgeSize);
            validateSizeNumber(Integer.parseInt(bridgeSize));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        moveDirection = Console.readLine();
        try {
            validateMoveDirectionChar(moveDirection);
            validateMoveDirection(moveDirection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
        return moveDirection;
    }

    public String readGameCommand() {
        gameCommand = Console.readLine();
        try {
            validateGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return gameCommand;
    }

    public void validateSizeNumber(int size) {
        if (size < MIN_RANGE || size > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_SIZE_NUMBER);
        }
    }

    public void validateSizeChar(String size) {
        if (!size.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_SIZE_CHAR);
        }
    }

    public void validateMoveDirection(String direction) {
        if (!direction.equals(UP_DIRECTION) && !direction.equals(DOWN_DIRECTION)) {
            throw new IllegalArgumentException(ERROR_MOVE_DIRECTION);
        }
    }

    public void validateMoveDirectionChar(String direction) {
        if (direction.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_MOVE_DIRECTION);
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(RESTART) && !gameCommand.equals(EXIT)) {
            throw new IllegalArgumentException(ERROR_GAME_COMMAND);
        }
    }

}
