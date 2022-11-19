package bridge.view;

import bridge.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String ENTER_MOVE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        new OutputView().printMessage(ENTER_BRIDGE_LENGTH);
        String input = Console.readLine().strip();

        new InputValidator(input).isInRangeSize();
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        new OutputView().printMessage(ENTER_MOVE_DIRECTION);
        String input = Console.readLine().strip();
        new InputValidator(input).isUpOrDown();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
