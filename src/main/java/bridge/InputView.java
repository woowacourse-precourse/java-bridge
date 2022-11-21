package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        new OutputView().printStartGame();
        String bridgeLength = Console.readLine();
        try {
            if (!bridgeLength.matches("[0-9]+") || (Integer.parseInt(bridgeLength) < 3 || Integer.parseInt(bridgeLength) > 20)) {
                new OutputView().printError("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        new OutputView().printMoveDirection();
        String direction = Console.readLine();
        try {
            if (!direction.equals("U") & !direction.equals("D")) {
                new OutputView().printError("[ERROR] 이동할 칸은 U 또는 D 여야만 합니다.");
                throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 여야만 합니다.");
            }
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
        return direction;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
