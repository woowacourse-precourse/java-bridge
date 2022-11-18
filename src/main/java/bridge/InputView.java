package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final OutputView outputView = new OutputView();

    public int readBridgeSize() {
        String inputBridgeSize = ""; boolean input = true;
        while (input) {
            try {outputView.printBridgeSizeToInput();
                inputBridgeSize = Console.readLine();
                input = Error.validateBridgeSizeIsWrong(inputBridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }}
        return Integer.parseInt(inputBridgeSize);
    }

    public String readMoving() {
        String inputMove = ""; boolean input = true;
        while (input) {
            try {outputView.printPlayerMove();
                inputMove = Console.readLine();
                input = Error.validatePlayerMove(inputMove);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }}
        return inputMove;
    }

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
