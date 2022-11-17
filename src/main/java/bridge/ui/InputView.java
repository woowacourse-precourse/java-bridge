package bridge.ui;

import bridge.message.Message;

import static bridge.message.Message.*;
import static bridge.ui.Validate.*;
import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
        String input = readLine();

        digitTypeValidate(input);

        int number = Integer.parseInt(input);
        numberRangeValidate(number);

        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(REQUEST_MOVE);
        String direction = readLine();

        directionValidate(direction);

        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(REQUEST_RETRY);
        String command = readLine();

        commandValidate(command);

        return command;
    }
}
