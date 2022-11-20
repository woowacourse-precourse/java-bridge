package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        int result = Integer.parseInt(bridgeSize);
        if (result < 3 || result > 20) {
            throw new IllegalArgumentException("Not Valid");
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        List<String> validMove = List.of("U", "D");

        if (!validMove.contains(moving)) {
            throw new IllegalArgumentException("Not Valid");
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        List<String> validCommand = List.of("R", "Q");

        if (!validCommand.contains(gameCommand)) {
            throw new IllegalArgumentException("Not Valid");
        }
        return gameCommand;
    }
}
