package bridge.view;

import bridge.enumeration.GameCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    // TODO: Error메시지 Enum으로 출력

    public int readBridgeSize() {
        String inputBridgeSize = Console.readLine();
        validBridgeSize(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    private void validBridgeSize(String inputBridgeSize) {
        if (!Pattern.matches("^[0-9]*$", inputBridgeSize)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        if (inputMoving.length() != 1) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        if (inputGameCommand.length() != 1) {
            throw new IllegalArgumentException();
        }
    }
}
