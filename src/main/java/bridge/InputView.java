package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Application.ERROR_PREFIX;
import static bridge.DIRECTION.DOWN;
import static bridge.DIRECTION.UP;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println("\n다리의 길이를 입력해주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "다리의 길이는 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.printf("\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n", UP.getValue(), DOWN.getValue());
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "R 또는 Q로 입력해야 합니다.");
        }
        return command;
    }
}
