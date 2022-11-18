package bridge.view;

import bridge.domain.BridgeBlock;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.*;

public class InputView {


    public int readBridgeSize() {
        return parseInt(readLine());
    }

    public String readMoving() {
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
