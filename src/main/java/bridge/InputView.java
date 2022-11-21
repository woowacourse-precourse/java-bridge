package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String REGEX = "[0-9]+";
    private final int minLength = 3;
    private final int maxLength = 20;


    //region 다리길이
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(Message.BRIDGE_SIZE);
            String input = Console.readLine();
            validateSize(input);
            return Integer.valueOf(input);
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            return readBridgeSize();
        }
    }

    private void validateSize(String input) {
        checkOnlyNumber(input);
        checkSize(input);
    }

    private void checkSize(String input) {
        int size = Integer.valueOf(input);
        if(size < minLength)
            throw new IllegalArgumentException(Message.ERROR_SMALL_SIZE);

        if(size > maxLength)
            throw new IllegalArgumentException(Message.ERROR_BIG_SIZE);
    }

    private void checkOnlyNumber(String input) {
        if(!input.matches(REGEX))
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER);
    }
    //endregion

    //region 이동
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(Message.MOVING);
            String input = Console.readLine();
            ValidateMove(input);
            return input;
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            return readMoving();
        }
    }

    private void ValidateMove(String input) {
        checkUpOrDown(input);
    }

    private void checkUpOrDown(String input) {
        if (!input.equals("U") && !input.equals("D"))
            throw new IllegalArgumentException(Message.ERROR_UP_AND_DOWN);
    }
    //endregion

    //region 재시도 여부
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(Message.GAME_COMMAND);
            String input = Console.readLine();
            ValidateGameCommand(input);
            return input;
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            return readGameCommand();
        }
    }

    private void ValidateGameCommand(String input) {
        checkRetryAndQuit(input);
    }

    private void checkRetryAndQuit(String input) {
        if (!input.equals("R") && !input.equals("Q"))
            throw new IllegalArgumentException(Message.ERROR_RETRY_AND_QUIT);
    }
    //endregion
}
