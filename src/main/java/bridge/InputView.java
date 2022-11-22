package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Error.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            int size = Integer.parseInt(Console.readLine());
            if (size < 3 || size > 20) {
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
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            String moving = Console.readLine();
            if (!moving.equals("U") && !moving.equals("D")) {
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
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            String command = Console.readLine();
            if (!command.equals("R") && !command.equals("Q")) {
                throw new IllegalArgumentException(COMMAND_ERROR.getMessage());
            }
            return command.equals("Q");
        } catch (Exception e) {
            throw new IllegalArgumentException(COMMAND_ERROR.getMessage());
        }
    }
}
