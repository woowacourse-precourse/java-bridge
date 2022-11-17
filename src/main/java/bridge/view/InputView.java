package bridge.view;

import bridge.util.ExceptionHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int getInputBridgeSize() throws IllegalArgumentException {
        OutputView.printInputBridgeSize();
        String input = readLine();
        ExceptionHandler.checkBridgeSize(input);
        return Integer.parseInt(input);
    }

    public static String getInputMoving() {
        OutputView.printInputMoving();
        String input = readLine();
        ExceptionHandler.checkMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
