package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Error.BRIDGE_SIZE_ERROR;
import static bridge.Error.MOVING_ERROR;

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
            if (moving != "U" && moving != "D") {
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
    public String readGameCommand() {
        return null;
    }
}
