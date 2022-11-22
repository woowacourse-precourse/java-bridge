package bridge.view;

import bridge.enums.ErrorText;
import bridge.enums.GameCommand;
import bridge.enums.InputText;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static final int MIN_BRIDGE_SIZE = 3;
    static final int MAX_BRIDGE_SIZE = 20;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        System.out.println(InputText.GAME_START_TEXT.getValue());
        System.out.println(InputText.BRIDGE_SIZE.getValue());
        return convertInt(readLine());
    }
    private int convertInt(String read) {
        if (!isDigit(read)) {
            throw new IllegalArgumentException(ErrorText.BRIDGE_SIZE_ERROR.getValue());
        }
        int size = Integer.parseInt(read);
        if (!validateBridgeSize(size)) {
            throw new IllegalArgumentException(ErrorText.BRIDGE_SIZE_ERROR.getValue());
        }
        return size;
    }
    private boolean isDigit(String read) {
        if (read.matches("[^0-9]*$")) {
            return false;
        }
        return true;
    }
    private boolean validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            return false;
        }
        return true;
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        System.out.println(InputText.MOVE_TO.getValue());
        String location = readLine();
        validateMoveLocation(location);
        return location;
    }
    private void validateMoveLocation(String location) {
        if (location.isEmpty() || !(GameCommand.MOVE_UP.isSame(location) ||GameCommand.MOVE_DOWN.isSame(location))) {
            throw new IllegalArgumentException(ErrorText.MOVE_TO_ERROR.getValue());
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputText.QUIT_OR_RETRY.getValue());
        String command = readLine();
        validateGameCommand(command);
        return command;
    }
    private void validateGameCommand(String command) {
        if (!(GameCommand.RETRY.isSame(command) || GameCommand.QUIT.isSame(command))) {
            throw new IllegalArgumentException(ErrorText.QUIT_ERROR.getValue());
        }
    }
}
