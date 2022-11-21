package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY = "";
    private static final String PRINT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_SELECT_MOVING_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PRINT_SELECT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println();
        System.out.println(PRINT_BRIDGE_SIZE);
        return Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println();
        System.out.println(PRINT_SELECT_MOVING_DIRECTION);
        return Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println();
        System.out.println(PRINT_SELECT_RETRY);
        return Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
    }
}
