package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readLine();
        validateDigit(input);
        validateRange(input);
        return Integer.parseInt(input);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateDigit(String input) {
        if(!input.matches("[0-9]+") {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.")
        }
    }

    private void validateRange(String input) {
        int size = Integer.parseInt(input);

        if( size < 3 && size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20 이하 숫자를 입력해주세요.");
        }
    }
}
