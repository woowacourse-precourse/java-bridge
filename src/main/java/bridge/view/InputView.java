package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요";
    private final String NUMBER_FORMAT_ERROR = "[ERROR] 다리의 길이는 숫자입니다.";
    private final String SELECT_CELL_MESSAGE = "이동할 칸을 선택해주세요";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(BRIDGE_SIZE_MESSAGE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException err) {
            System.out.println(NUMBER_FORMAT_ERROR);
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {;
        System.out.println(SELECT_CELL_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
