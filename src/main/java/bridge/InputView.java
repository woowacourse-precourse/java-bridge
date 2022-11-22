package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */

    private OutputView outputView = new OutputView();

    public int readBridgeSize() {
        int num = 0;
        String input = Console.readLine();
        try {
            if ((num = Integer.parseInt(input)) < 3 || num > 20)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            outputView.printReadSizeError();
            throw new IllegalArgumentException();
        }
        return num;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if (!input.equals("D") && !input.equals("U")) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String input = Console.readLine();
        if (input.equals("R"))
            return true;

        return false;
    }
}
