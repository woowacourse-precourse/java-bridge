package bridge.view;

import bridge.util.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int bridgeSize = 0;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            ValidationUtil.isValidBridgeLength(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String inputKey = "";
        try {
            inputKey = Console.readLine();
            ValidationUtil.isUpOrDown(inputKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputKey;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String inputKey = "";
        try {
            inputKey = Console.readLine();
            ValidationUtil.isRetryOrQuit(inputKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputKey;
    }
}
