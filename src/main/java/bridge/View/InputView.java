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
        int bridgeSize;

        try {
            bridgeSize = VerificationUtil.verifyNumeric(Console.readLine());
            VerificationUtil.verifyBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving;

        try {
            moving = Console.readLine();
            VerificationUtil.verifyMoving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moving = readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String command;

        try {
            command = Console.readLine();
            VerificationUtil.verifyGameCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            command = readGameCommand();
        }
        return command;
    }
}
