package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    // 다리 길이 입력받는 기능
    public int readBridgeSize() {
        String input = Console.readLine();
        checkIsNumber(input);
        return Integer.parseInt(input);
    }

    // 숫자가 아닐경우 예외처리
    private void checkIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해야 합니다.");
            }
        }
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
}
