package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final OutputView outputView = new OutputView();
    private final Exception exception = new Exception();

    public int readBridgeSize() {
        String input;
        outputView.printGameStart();
        do {
            outputView.printGetBridgeSize();
            input = Console.readLine();
        } while (!validateBridgeSize(input));

        outputView.printNewLine();
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input;
        do {
            outputView.printGetNextBlock();
            input = Console.readLine();
        } while (!validateMoving(input));
        return input;
    }

    public int readGameCommand() {
        String input;
        do {
            outputView.printRetry();
            input = Console.readLine();
        } while (!validateGameCommand(input));
        if (input.equals("R")){
            return Constant.GAME_RESTART;
        }
        return Constant.GAME_FAIL;
    }

    // 검증 메소드
    private Boolean validateBridgeSize(String input) {
        try {
            if (!isNumeric(input) ||
                    (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20)){
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e){
            return exception.exceptionBridgeSize();
        }
    }

    private Boolean validateMoving(String input) {
        try {
            if (!isUorD(input)){
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e){
            return exception.exceptionMoving();
        }
    }

    private Boolean validateGameCommand(String input) {
        try {
            if (!isRorQ(input)){
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e){
            return exception.exceptionGameCommand();
        }
    }


    private Boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private Boolean isUorD(String input) {
        try {
            return input.equals("U") || input.equals("D");
        } catch (NullPointerException e){
            return false;
        }
    }

    private Boolean isRorQ(String input) {
        try {
            return input.equals("R") || input.equals("Q");
        } catch (NullPointerException e){
            return false;
        }
    }
}
