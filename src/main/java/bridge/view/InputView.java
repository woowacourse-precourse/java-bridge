package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Validator.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            validateBridge(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 길이는 자연수만 입력 가능합니다.");
        }
        return 0;
    }

}