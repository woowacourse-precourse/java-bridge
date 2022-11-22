package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String userInput = Console.readLine();
        if (userInput == null ||
                !userInput.matches("^[0-9]{1,2}$") ||
                Integer.parseInt(userInput) < 3 ||
                Integer.parseInt(userInput) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return Integer.parseInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String ERROR_MSG = "[ERROR] 이동할 칸은 U나 D로 입력해야 합니다.";
        String userInput = Console.readLine();
        if (userInput == null || !userInput.matches("^[U,D]$")) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readRetryCommand() {
        String ERROR_MSG = "[ERROR] 다시 시작할 지 여부는 R이나 Q로 입력해야 합니다.";
        String userInput = Console.readLine();
        if (userInput == null | !userInput.matches("^[R,Q]$")) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return userInput;
    }
}
