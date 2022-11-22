package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        OutputView.printGameStart();
        OutputView.inputBridgeSize();
        return Integer.parseInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.inputMoveDirection();
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.inputGameRestart();
        return Console.readLine();
    }
}
