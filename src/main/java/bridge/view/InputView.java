package bridge.view;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import static bridge.utils.constant.OutputMessage.*;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        while(true) {
            try {
                System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
                String input = Console.readLine();
                InputValidator.validateBridgeSize(input);
                return Integer.parseInt(input);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
