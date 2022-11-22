package bridge.view;

import static bridge.validator.InputValidator.*;

import bridge.domain.Direction;
import camp.nextstep.edu.missionutils.Console;
import static bridge.utils.constant.OutputMessage.*;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true) {
            try {
                System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
                String input = Console.readLine();
                validateBridgeSize(input);
                return Integer.parseInt(input);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        while(true) {
            try {
                System.out.println(DIRECTION_INPUT_MESSAGE);
                String input = Console.readLine();
                validateDirection(input);
                return Direction.of(input);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true) {
            try {
                System.out.println(GAME_COMMAND_MESSAGE);
                String input = Console.readLine();
                validateCommand(input);
                return input;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
