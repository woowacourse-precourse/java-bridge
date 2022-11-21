package bridge.View;

import bridge.Util.VerificationUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView() {}

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {

        OutputView.printEnterBridgeSize();

        String bridgeSize = Console.readLine();
        return VerificationUtil.verifyBridgeSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {

        OutputView.printEnterMovingSpace();
        String moving = Console.readLine();

        VerificationUtil.verifyMoving(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {

        OutputView.printRetryOrQuit();
        String command = Console.readLine();

        VerificationUtil.verifyGameCommand(command);

        return command;
    }
}
