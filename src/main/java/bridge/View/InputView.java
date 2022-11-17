package bridge.View;

import bridge.Model.ErrorUtil;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    ErrorUtil errorUtil = new ErrorUtil();
    public int readBridgeSize() {
        String inputSize = readLine();
        errorUtil.errorBridgeSizeNotNumber(inputSize);
        int size = Integer.parseInt(inputSize);
        errorUtil.errorBridgeSize(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputUpDown = readLine();
        errorUtil.errorInputReadMoving(inputUpDown);
        return inputUpDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
