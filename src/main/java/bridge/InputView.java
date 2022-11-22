package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BLANK = "";
    private static final OutputView outputView = new OutputView();

    public int readBridgeSize() {
        String inputBridgeSize = BLANK;
        boolean input = true;
        while (input) {
            try {
                outputView.printBridgeSizeToInput();
                inputBridgeSize = Console.readLine();
                input = Exception.validateBridgeSize(inputBridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(inputBridgeSize);
    }

    public String readMoving() {
        String inputMove = BLANK;
        boolean input = true;
        while (input) {
            try {
                outputView.printPlayerMove();
                inputMove = Console.readLine();
                input = Exception.validatePlayerMove(inputMove);
            } catch (IllegalArgumentException exceptionMessage) {
                System.out.println(exceptionMessage.getMessage());
            }
        }
        return inputMove;
    }

    public String readGameCommand() {
        String progress = BLANK;
        boolean input = true;
        while (input) {
            try {
                outputView.printProgress();
                progress = Console.readLine();
                input = Exception.validateGameProgress(progress);
            } catch (IllegalArgumentException exceptionMessage) {
                System.out.println(exceptionMessage.getMessage());
            }
        }
        return progress;
    }

}
