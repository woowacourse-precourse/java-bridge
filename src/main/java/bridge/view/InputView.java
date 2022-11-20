package bridge.view;

import bridge.valid.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String SELECT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RESUME_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        return convertToInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(SELECT_MOVING);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESUME_GAME);
        return Console.readLine();
    }

    public void printError(String text) {
        System.out.println(text);
    }

    private int convertToInt(String input) {
        Validation.inputNumberValid(input);
        return Integer.parseInt(input);
    }
}
