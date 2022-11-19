package bridge.view;

import bridge.util.TypeConverter;
import bridge.validate.ValidateInput;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static int readBridgeSize() {
        String beforeValidateBridgeSize = Console.readLine();
        ValidateInput.validateBridgeSize(beforeValidateBridgeSize);
        int bridgeSize = TypeConverter.stringToInt(beforeValidateBridgeSize);
        OutputView.enter();
        return bridgeSize;
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
