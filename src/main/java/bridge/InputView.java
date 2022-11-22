package bridge;

import camp.nextstep.edu.missionutils.Console;
import static bridge.ui.ErrorMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            return Integer.valueOf(Console.readLine());
        } catch (Exception err) {
            throw new IllegalArgumentException(BridgeFormERROR.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            return Console.readLine();
        } catch (Exception err) {
            throw new IllegalArgumentException(MoveFormERROR.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            return Console.readLine();
        } catch (Exception err) {
            throw new IllegalArgumentException(RestartFormERROR.getMessage());
        }
    }
}
