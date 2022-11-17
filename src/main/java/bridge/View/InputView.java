package bridge.View;

import bridge.Utils.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * (추가) 올바르지 않을경우(Exception) 기본적으로 메소드를 재귀한다.
 */
public class InputView extends OutputView {

    public static final Validation validate = new Validation();

    public InputView() {
        start();
    }
    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        printGetUserBridgeSize();
        String inputSize = Console.readLine();

        try {
            return validate.checkSizeReturnInt(inputSize);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        // TODO: 사용자 입력 검증
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        // TODO: 사용자 입력 검증
        return null;
    }
}
