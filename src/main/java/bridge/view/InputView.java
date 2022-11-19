package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String PRINT_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PRINT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public InputView() {

    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println();
        System.out.println(PRINT_SIZE);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println();
        System.out.println(PRINT_MOVE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println();
        System.out.println(PRINT_RETRY);
        return Console.readLine();
    }
}
