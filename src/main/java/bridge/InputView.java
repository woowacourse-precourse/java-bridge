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
        outputView.printBridgeSizeQuestion();
        String input = Console.readLine();
        int num = 0;
        try {
            num = validateReadBridgeSize(input);
        } catch (IllegalArgumentException e) {
            outputView.printReadSizeError();
            return readBridgeSize();
        }
        return num;
    }

    public int validateReadBridgeSize(String input) {
        int num = 0;
        try {
            if ((num = Integer.parseInt(input)) < 3 || num > 20) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return num;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMovingQuestion();
        String input = Console.readLine();
        try {
            validateReadMoving(input);
        } catch (IllegalArgumentException e) {
            outputView.printReadMovingError();
            return readMoving();
        }
        return input;
    }

    public void validateReadMoving(String input) {
        if (!input.equals("D") && !input.equals("U")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        outputView.printGameCommandQuestion();
        String input = Console.readLine();
        try {
            validateReadGameCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printReadGameCommandError();
            return readGameCommand();
        }
        if (input.equals("R")) return true;
        return false;
    }

    public void validateReadGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
