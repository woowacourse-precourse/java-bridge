package bridge.ui;

import static bridge.message.Message.*;
import static bridge.ui.Validate.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = request(REQUEST_BRIDGE_SIZE);

        digitTypeValidate(input);

        int number = Integer.parseInt(input);
        numberRangeValidate(number);

        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String direction = request(REQUEST_MOVE);

        directionValidate(direction);

        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = request(REQUEST_RETRY);

        commandValidate(command);

        return command;
    }

    private String request(String message) {
        System.out.println(message);
        return readLine();
    }

}
