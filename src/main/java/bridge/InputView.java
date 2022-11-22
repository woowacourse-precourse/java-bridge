package bridge;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorMessage;
import domain.InputMessage;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        startMessage();
        String size = Console.readLine();
        validateBridge(size);
        return Integer.parseInt(size);
    }

    private void startMessage() {
        System.out.println(InputMessage.START_MESSAGE.getMessage());
        System.out.println();
        System.out.println(InputMessage.INPUT_BRIDGE_MESSAGE.getMessage());
    }

    public void validateBridge(String bridge) {
        isNumber(bridge);
        isOutOfSize(bridge);
    }

    private void isNumber(String bridge) {
        String regex = "^\\d*$";
        if(!Pattern.matches(regex,bridge)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void isOutOfSize(String bridge) {
        int number = Integer.parseInt(bridge);
        if(number < 3 || number > 20) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BRIDGE_SIZE.getMessage());
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        movingMessage();
        String command = Console.readLine();
        validateMovingCommand(command);
        return command;
    }

    private void movingMessage() {
        System.out.println();
        System.out.println(InputMessage.INPUT_MOVING_MESSAGE.getMessage());
    }

    public void validateMovingCommand(String command) {
        isMovingCommand(command);
    }

    private void isMovingCommand(String command) {
        String regex = "^[DU]$";
        if(!Pattern.matches(regex, command)){
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHING_MOVING_COMMAND.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        endMessage();
        String command = Console.readLine();
        validateGameCommand(command);
        return command;
    }

    private void endMessage() {
        System.out.println();
        System.out.println(InputMessage.INPUT_GAME_MESSAGE.getMessage());
    }

    public void validateGameCommand(String command) {
        isGameCommand(command);
    }

    private void isGameCommand(String command) {
        String regex = "^[RQ]$";
        if(!Pattern.matches(regex, command)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHING_GAME_COMMAND.getMessage());
        }
    }
}
