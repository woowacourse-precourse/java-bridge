package bridge.view;

import bridge.domain.Step;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String MSG_INPUT_BRIDGE_SIZE = "%n다리의 길이를 입력해주세요.%n";
    private static final String MSG_INPUT_STEP = "%n이동할 칸을 선택해주세요. (위: U, 아래: D)%n";
    private static final String MSG_INPUT_RETRY_OR_QUIT = "%n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n";
    private static final String COMMAND_RETRY = "R";
    private static final String COMMAND_QUIT = "Q";
    private static final String ERROR_BRIDGE_TYPE = "숫자를 입력해야 합니다.";
    private static final String ERROR_OPTION_CHARACTER = "옵션 문자를 입력해야 합니다. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.printf(MSG_INPUT_BRIDGE_SIZE);
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_BRIDGE_TYPE);
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Step readMoving() {
        System.out.printf(MSG_INPUT_STEP);
        return Step.findByUserInputDirection(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.printf(MSG_INPUT_RETRY_OR_QUIT);
        String command = Console.readLine();
        if (COMMAND_RETRY.equals(command) || COMMAND_QUIT.equals(command)) {
            return command;
        }
        throw new IllegalArgumentException(ERROR_OPTION_CHARACTER);
    }
}
