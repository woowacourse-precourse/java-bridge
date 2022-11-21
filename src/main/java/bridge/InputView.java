package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(inputMessage.INPUT_LENGTH.get());
        String bridgeSize;

        do {
            bridgeSize = Console.readLine();
        } while (!handleSizeException(bridgeSize));

        return Integer.parseInt(bridgeSize);
    }

    public void validateSize(String size) {
        if (!Pattern.matches("^[0-9]*$", size)) {
            throw new IllegalArgumentException(OutputMessage.ERROR.get() + OutputMessage.ERROR_BRIDGE_SIZE.get());
        }

        if ((Integer.parseInt(size) < 3) || (Integer.parseInt(size) > 20)) {
            throw new IllegalArgumentException(OutputMessage.ERROR.get() + OutputMessage.ERROR_BRIDGE_SIZE.get());
        }
    }

    public boolean handleSizeException(String bridgeSize) {
        try {
            validateSize(bridgeSize);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(inputMessage.INPUT_MOVE.get());
        String moving;

        do {
            moving = Console.readLine();
        } while (!handleMovingException(moving));

        return validateMoving(moving);
    }

    public String validateMoving(String moving) {
        if (moving.equals(Command.UP.get().toLowerCase()) || moving.equals(Command.DOWN.get().toLowerCase())) {
            throw new IllegalArgumentException(OutputMessage.ERROR.get() + OutputMessage.ERROR_LOWER_MOVING_COMMAND.get());
        }

        if (!(moving.equals(Command.UP.get()) || moving.equals(Command.DOWN.get()))) {
            throw new IllegalArgumentException(OutputMessage.ERROR.get() + OutputMessage.ERROR_NOT_MOVING_COMMAND.get());
        }

        return moving;
    }

    public boolean handleMovingException(String moving) {
        try {
            validateMoving(moving);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(inputMessage.INPUT_RETRY.get());
        String retryCommand;

        do {
            retryCommand = Console.readLine();
        } while (!handleRetryException(retryCommand));

        return validateRetry(retryCommand);
    }

    public String validateRetry(String retry) {
        if (retry.equals(Command.RETRY.get().toLowerCase()) || retry.equals(Command.QUIT.get().toLowerCase())) {
            throw new IllegalArgumentException(OutputMessage.ERROR.get() + OutputMessage.ERROR_LOWER_RETRY_COMMAND.get());
        }

        if (!(retry.equals(Command.RETRY.get()) || retry.equals(Command.QUIT.get()))) {
            throw new IllegalArgumentException(OutputMessage.ERROR.get() + OutputMessage.ERROR_NOT_RETRY_COMMAND.get());
        }

        return retry;
    }

    public boolean handleRetryException(String retry) {
        try {
            validateRetry(retry);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

enum inputMessage {

    INPUT_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MOVE("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    inputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}