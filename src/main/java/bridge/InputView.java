package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public Integer readBridgeSize() {
        String input = readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 입력받은 다리의 길이를 검증한다.
     */
    private void validateBridgeSize(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
            if (size < 3 || size > 20) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = readLine();
        validateMoving(input);
        return input;
    }

    /**
     * 입력받은 이동할 칸을 검증한다.
     */
    private void validateMoving(String moving) {
        if (!("U".equals(moving) || "D".equals(moving))) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = readLine();
        validateCommand(input);
        return input;
    }

    private void validateCommand(String command) {
        if (!("R".equals(command) || "Q".equals(command))) {
            throw new IllegalArgumentException();
        }
    }
}
