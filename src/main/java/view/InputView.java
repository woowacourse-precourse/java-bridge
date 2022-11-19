package view;

import camp.nextstep.edu.missionutils.Console;
import util.ValidationUtil;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final static String PLEASE_INPUT_BRDIGE_SIZE = "다리의 길이를 입력해주세요.";

    final static String PLEASE_CHOOSE_MOVE_SPOT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    final static String PLEASE_INPUT_RETRY_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String consoleInput = Console.readLine();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(PLEASE_INPUT_BRDIGE_SIZE);
        int bridgeSize = Integer.parseInt(consoleInput);
        return ValidationUtil.isValidSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(PLEASE_CHOOSE_MOVE_SPOT);
        String moving = consoleInput;

        return ValidationUtil.isValidMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(PLEASE_INPUT_RETRY_OR_NOT);
        String retrial = consoleInput;
        return ValidationUtil.isValidRetry(retrial);
    }
}
