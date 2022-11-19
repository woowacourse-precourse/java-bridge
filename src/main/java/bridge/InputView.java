package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        try {
            System.out.println(Constant.READ_BRIDGE_SIZE);
            String input = Console.readLine();
            return Validator.validatedBridgeSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
