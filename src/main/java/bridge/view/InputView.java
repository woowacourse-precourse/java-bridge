package bridge.view;

import static bridge.model.ErrorThrower.ERROR_BRIDGE_SIZE;
import static bridge.model.ErrorThrower.ERROR_MOVING;
import static bridge.model.ErrorThrower.ERROR_RETRY;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.model.ErrorThrower;
import bridge.model.InputValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String input = readLine();
        if (InputValidator.isValidSize(input)) {
            return Integer.parseInt(input);
        }
        ErrorThrower.throwError(ERROR_BRIDGE_SIZE);
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String inputMoving = readLine();
        if (InputValidator.isValidMoving(inputMoving)) {
            return inputMoving;
        }
        ErrorThrower.throwError(ERROR_MOVING);
        return readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY);
        String inputRetry = readLine();
        if (InputValidator.isValidRetry(inputRetry)) {
            return inputRetry;
        }
        ErrorThrower.throwError(ERROR_RETRY);
        return readGameCommand();
    }
}
