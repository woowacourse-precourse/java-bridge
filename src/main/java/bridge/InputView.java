package bridge;

import static bridge.Validator.validateInputDIRECTION;
import static bridge.Validator.validateInputLowerCase;
import static bridge.Validator.validateInputNull;
import static bridge.Validator.validateInputSize;
import static bridge.Validator.validateInputType;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static int bridgeSize;
    private static String inputSize;
    private static String inputDirection;
    private static String inputRestart;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int inputBridgeSize() {
        System.out.println(Message.INPUT_SIZE.getMessage());
        inputSize = readLine();
        System.out.println();
        validateInputType(inputSize);
        validateInputNull(inputSize);
        bridgeSize = Integer.parseInt(inputSize);
        validateInputSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputMovingDirection() {
        System.out.println(Message.SELECT_DIRECTION.getMessage());
        inputDirection = readLine();
        validateInputDIRECTION(inputDirection);
        validateInputLowerCase(inputDirection);
        return inputDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String inputGameRestart() {
        System.out.println(Message.ASK_RESTART.getMessage());
        inputRestart = readLine();
        return inputRestart;
    }
}
