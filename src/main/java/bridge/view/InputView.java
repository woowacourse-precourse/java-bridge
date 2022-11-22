package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String INPUT_MOVING_POSITION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_RESTART_OR_END_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final String LINE_BREAK = "\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);

        String bridgeSize = Console.readLine();

        System.out.print(LINE_BREAK);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_POSITION_MESSAGE);

        String movingPosition = Console.readLine();

        return movingPosition;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RESTART_OR_END_COMMAND_MESSAGE);

        String restartOrQuitCommand = Console.readLine();

        return restartOrQuitCommand;
    }
}
