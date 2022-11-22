package bridge.view;

import bridge.exception.ExceptionHandler;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize()
    {
        OutputView.printStart();
        String bridgeSize="";

        return  ExceptionHandler.sizeValidTest(bridgeSize);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printMoving();
        String moving="";

        return ExceptionHandler.movingValidTest(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printRetry();
        String gameCommand = "";
        return ExceptionHandler.gameCommandValidTest(gameCommand);
    }

}

