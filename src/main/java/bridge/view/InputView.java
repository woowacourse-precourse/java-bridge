package bridge.view;

import bridge.model.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readBridgeSize() {
        String input = Console.readLine();
        Validator.validateSize(input);
        return Integer.parseInt(input);
    }

    public static String readMoving() {
        String input = Console.readLine();

        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
