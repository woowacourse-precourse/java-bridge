package bridge.ui;

import static bridge.ui.InputValidator.*;
import static bridge.ui.MessageUtil.EMPTY_INPUT;
import static bridge.ui.MessageUtil.INVALID_BRIDGE_SIZE;
import static bridge.ui.MessageUtil.INVALID_GAME_CMD;
import static bridge.ui.MessageUtil.INVALID_MOVE_CHOICE;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public String userInput(){
        String input = Console.readLine();
        if (isInputBlank(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT.message);
        }
        return input;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        String bridgeSize = input;
        if (!isValidBridge(bridgeSize)){
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.message);
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String input) {
        String move = input;
        if (!isValidMove(move)){
            throw new IllegalArgumentException(INVALID_MOVE_CHOICE.message);
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String input) {
        String cmd = input;
        if (!isValidCmd(cmd)){
            throw new IllegalArgumentException(INVALID_GAME_CMD.message);
        }
        return cmd;
    }
}
