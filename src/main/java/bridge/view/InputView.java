package bridge.view;

import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        return input;
    }

    public String readMoving() {
        return Console.readLine();
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}
