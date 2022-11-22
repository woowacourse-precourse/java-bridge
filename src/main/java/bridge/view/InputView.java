package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INVAILD_INPUT_ERROR = "[ERROR] 잘못된 입력값 입니다.";

    public int readBridgeSize() {
        try {
            int size = Integer.parseInt(Console.readLine());
            return size;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVAILD_INPUT_ERROR);
        }
    }

    public String readMoving() {
        return Console.readLine();
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}
