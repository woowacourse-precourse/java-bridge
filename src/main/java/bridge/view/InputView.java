package bridge.view;

import bridge.enumeration.ErrorMessage;
import bridge.enumeration.GameCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String inputBridgeSize = Console.readLine();
        validBridgeSize(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    private void validBridgeSize(String inputBridgeSize) {
        if (!Pattern.matches("^[0-9]*$", inputBridgeSize)) {
            System.out.println(ErrorMessage.NOT_NUMBER.getErrorMessage());
            throw new NoSuchElementException(ErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMoving = Console.readLine();
        validMoving(inputMoving);
        return inputMoving;
    }

    private void validMoving(String inputMoving) {
        if (!inputMoving.contains(GameCommand.UP.getCommand()) && !inputMoving.contains(
            GameCommand.DOWN.getCommand())) {
            System.out.println(ErrorMessage.NOT_U_OR_D.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_U_OR_D.getErrorMessage());
        }
        if (inputMoving.length() != 1) {
            System.out.println(ErrorMessage.INPUT_OUT_OF_RANGE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.INPUT_OUT_OF_RANGE.getErrorMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputGameCommand = Console.readLine();
        validGameCommand(inputGameCommand);
        return inputGameCommand;
    }

    private void validGameCommand(String inputGameCommand) {
        if (!inputGameCommand.contains(GameCommand.RESTART.getCommand())
            && !inputGameCommand.contains(GameCommand.QUIT.getCommand())) {
            System.out.println(ErrorMessage.NOT_R_OR_Q.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_R_OR_Q.getErrorMessage());
        }
        if (inputGameCommand.length() != 1) {
            System.out.println(ErrorMessage.INPUT_OUT_OF_RANGE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.INPUT_OUT_OF_RANGE.getErrorMessage());
        }
    }
}
