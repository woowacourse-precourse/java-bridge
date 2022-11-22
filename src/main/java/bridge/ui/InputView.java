package bridge.ui;

import static bridge.domain.InputErrorCheck.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String READ_BRIDGE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_MESSAGE);
        String bridgeSize = readLine();

        readBridgeSizeErrorCheck(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_MESSAGE);
        String movingSpace = readLine();

        readMovingErrorCheck(movingSpace);

        return movingSpace;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_COMMAND_MESSAGE);
        String command = readLine();

        readGameCommandErrorCheck(command);

        return command;
    }
}
