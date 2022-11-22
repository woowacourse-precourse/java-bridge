package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Error.*;
import static bridge.Constants.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        try {
            int size = Integer.parseInt(Console.readLine());
            if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.getMessage());
            }
            return size;
        } catch (Exception e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_MESSAGE);
        try {
            String moving = Console.readLine();
            if (!moving.equals(UP) && !moving.equals(DOWN)) {
                throw new IllegalArgumentException(MOVING_ERROR.getMessage());
            }
            return moving;
        } catch (Exception e) {
            throw new IllegalArgumentException(MOVING_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println(COMMAND_MESSAGE);
        try {
            String command = Console.readLine();
            if (!command.equals(RESTART) && !command.equals(QUIT)) {
                throw new IllegalArgumentException(COMMAND_ERROR.getMessage());
            }
            return command.equals(QUIT);
        } catch (Exception e) {
            throw new IllegalArgumentException(COMMAND_ERROR.getMessage());
        }
    }
}
