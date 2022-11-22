package bridge.view;

import bridge.exception.constant.Exception;
import bridge.exception.input.InputException;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    OutputView outputView;
    public InputView(){
        outputView = new OutputView();
    }


    public String readBridgeSize() {
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */

    public String readGameCommand() {
        return Console.readLine();
    }
}
