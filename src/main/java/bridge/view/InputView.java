package bridge.view;

import static bridge.Constants.RESTART_GAME;
import static bridge.Constants.QUIT_GAME;
import static bridge.Constants.UP_BRIDGE;
import static bridge.Constants.DOWN_BRIDGE;
import static bridge.ErrorControl.validateBridgeSize;
import static bridge.ErrorControl.validateLetter;
import static bridge.ErrorControl.validateNumberOrNot;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        int bridgeSize = validateNumberOrNot(input);
        validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateLetter(input, UP_BRIDGE, DOWN_BRIDGE);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateLetter(input, RESTART_GAME, QUIT_GAME);
        return input;
    }
}
