package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" 숫자를 입력해 주세요");
        }
    }

    public String readMoving() {
        String input = Console.readLine();
        checkUpDown(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void checkUpDown(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(" U 또는 D 를 입력해 주세요");
        }
    }
}
