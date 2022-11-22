package bridge.view;

import static bridge.Constants.INPUT_BRIDGE_LENGTH_MESSAGE;
import static bridge.Constants.INPUT_COMMAND_MESSAGE;
import static bridge.Constants.INPUT_POSITION_MESSAGE;
import static bridge.Constants.RESTART_GAME;
import static bridge.Constants.QUIT_GAME;
import static bridge.Constants.START_MESSAGE;
import static bridge.Constants.UP_BRIDGE;
import static bridge.Constants.DOWN_BRIDGE;
import static bridge.ErrorControl.validateLetter;
import static bridge.ErrorControl.validateNumber;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static private boolean validated;
    static private String input;

    /**
     * 다리의 길이를 입력받는다.
     */
    static public int readBridgeSize() {
        System.out.println(START_MESSAGE);
        do {
            System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
            input = Console.readLine();
            validated = validateNumber(input);
        } while (!validated);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    static public String readMoving() {
        do {
            System.out.println(INPUT_POSITION_MESSAGE);
            input = Console.readLine();
            validated = validateLetter(input, UP_BRIDGE, DOWN_BRIDGE);
        } while (!validated);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    static public String readGameCommand() {
        do {
            System.out.println(INPUT_COMMAND_MESSAGE);
            input = Console.readLine();
            validated = validateLetter(input, RESTART_GAME, QUIT_GAME);
        } while (!validated);
        return input;
    }
}
