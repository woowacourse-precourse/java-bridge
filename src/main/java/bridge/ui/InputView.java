package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public final String BRIDGE_SIZE_MENT = "다리의 길이를 입력해주세요";
    public final String MOVING_MENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public final String RETRY_MENT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MENT);
        String s = Console.readLine();
        // validateBridgeSize(s)
        int bridgeSize = Integer.parseInt(s);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_MENT);
        String s = Console.readLine();
        // validateMoving(s)
        return s;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_MENT);
        String s = Console.readLine();
        // validateGameCommand(s);
        return s;
    }
}
