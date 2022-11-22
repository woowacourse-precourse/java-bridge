package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    //region 다리길이
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.BRIDGE_SIZE);
        String input = Console.readLine();
        validateSize(input);

        return Integer.valueOf(input);
    }

    private void validateSize(String input) {
        checkOnlyNumber(input);
        checkSize(input);
    }

    private void checkSize(String input) {
        int size = Integer.valueOf(input);
        if(size < Constant.MIN_LENGTH)
            throw new IllegalArgumentException(Message.ERROR_SMALL_SIZE);

        if(size > Constant.MAX_LENGTH)
            throw new IllegalArgumentException(Message.ERROR_BIG_SIZE);
    }

    private void checkOnlyNumber(String input) {
        if(!input.matches(Constant.REGEX))
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER);
    }
    //endregion

    //region 이동
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.MOVING);
        String input = Console.readLine();
        validateMove(input);

        return input;
    }

    private void validateMove(String input) {
        checkUpOrDown(input);
    }

    private void checkUpOrDown(String input) {
        if(!Step.validStep(input))
            throw new IllegalArgumentException(Message.ERROR_UP_AND_DOWN);
    }
    //endregion

    //region 재시도 여부
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.GAME_COMMAND);
        String input = Console.readLine();
        validateGameCommand(input);

        return input;
    }

    private void validateGameCommand(String input) {
        checkRetryAndQuit(input);
    }

    private void checkRetryAndQuit(String input) {
        if (!Retry.validRetry(input))
            throw new IllegalArgumentException(Message.ERROR_RETRY_AND_QUIT);
    }
    //endregion
}
