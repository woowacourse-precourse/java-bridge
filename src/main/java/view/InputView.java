package view;

import camp.nextstep.edu.missionutils.Console;
import model.User;
import util.ErrorMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]*$";


    public int readBridgeSize() {
        String usersInput = Console.readLine();
        validateDigit(usersInput);
        int bridgeSize = Integer.parseInt(usersInput);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String oneStairs = Console.readLine();
        return oneStairs;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validateCommand(gameCommand);
        return gameCommand;
    }

    private void validateCommand(String command) {
        if (!command.equals(User.COMMAND_RETRY) && !command.equals(User.COMMAND_QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.COMMAND_R_OR_Q);
        }
    }


    public void validateDigit(String input){
        if (!isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_DIGIT);
        }

    }
    private boolean isDigit(String input){
        if (!input.matches(NUMBER_REGEX)) {
            return false;
        }
        return true;
    }


    public void validateCharacter(String oneStairs) {
        if (isDigit(oneStairs)) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_CHARACTER);
        }
    }
}
