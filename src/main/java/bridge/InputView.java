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
        int bridgeSize = validateSize(Console.readLine());
        return bridgeSize;
    }

    public int validateSize(String size) {
        if ((Integer.parseInt(size) < 3) || (Integer.parseInt(size) > 20)) {
            throw new IllegalArgumentException(StateMessage.ERROR.get() + StateMessage.ERROR_BRIDGE_SIZE.get());
        }

        if (!Pattern.matches("^[0-9]*$", size)) {
            throw new IllegalArgumentException(StateMessage.ERROR.get() + StateMessage.ERROR_BRIDGE_SIZE.get());
        }

        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(inputMessage.INPUT_MOVE.get());
        String moving = validateMoving(Console.readLine());
        return moving;
    }

    public String validateMoving(String moving) {
        moving = moving.toUpperCase();

        if (!moving.equals(Command.UP.get()) || !moving.equals(Command.DOWN.get())) {
            throw new IllegalArgumentException(StateMessage.ERROR.get() + StateMessage.ERROR_MOVING_COMMAND.get());
        }

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(inputMessage.INPUT_RETRY.get());
        String retryCommand = validateRetry(Console.readLine());
        return retryCommand;
    }

    public String validateRetry(String retry) {
        retry = retry.toUpperCase();

        if (!retry.equals(Command.RETRY.get()) || !retry.equals(Command.QUIT.get())) {
            throw new IllegalArgumentException(StateMessage.ERROR.get() + StateMessage.ERROR_RETRY_COMMAND.get());
        }

        return retry;
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