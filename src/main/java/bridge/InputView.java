package bridge;

import bridge.Exception.ErrorType;
import bridge.Validate.ValidateInput;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();
    ValidateInput validateInput = new ValidateInput();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();

        validateInput.isInputSizeOneOrTwo(bridgeSizeInput);

        validateInput.isNumber(bridgeSizeInput);

        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        validateInput.isNumberThreeToTwenty(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingInput = Console.readLine();

        validateInput.isInputSizeOne(movingInput);

        validateInput.isUpOrDown(movingInput);

        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
