package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();

        isDigit(userInput);

        int bridgeSize = Integer.parseInt(userInput);
        isValidBridgeSize(bridgeSize);

        return bridgeSize;
    }

    private void isDigit(String userInput) {
        if (!Pattern.matches("^[0-9]+$", userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
        }
    }

    private void isValidBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 수만 입력해야 합니다");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        String userInput = Console.readLine();

        return Move.createMove(userInput);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = Console.readLine();
        isValidGameCommand(userInput);
        return userInput;
    }

    private void isValidGameCommand(String userInput) {
        if (!Pattern.matches("^[RQ]{1}$", userInput)) {
            throw new IllegalArgumentException("[ERROR] R 혹은 Q 한 문자를 입력해야 합니다");
        }
    }


}
