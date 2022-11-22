package bridge.view;

import static bridge.utils.ValidateUtils.*;
import static bridge.view.message.ErrorMessage.INPUT_NUMBER_RANGE_ERROR;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = readLine();
        validateNumberType(bridgeSize);
        validateNumberRange(Integer.parseInt(bridgeSize));
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = readLine();
        validateMoveType(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = readLine();
        validateGameRetry(command);
        return command;
    }
}
