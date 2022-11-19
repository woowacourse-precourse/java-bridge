package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        try {
            System.out.println(Constant.READ_BRIDGE_SIZE);
            String input = Console.readLine();
            return Validator.validatedBridgeSize(input);
        } catch (IllegalArgumentException bridgeSizeError) {
            System.out.println(bridgeSizeError.getMessage());
            readBridgeSize();
        }
        return 0;
    }

    public String readMoving() {
        try {
            System.out.println(Constant.READ_MOVING);
            String input = Console.readLine();
            Validator.validateMoving(input);
            return input;
        } catch (IllegalArgumentException movingError) {
            System.out.println(movingError.getMessage());
            readMoving();
        }
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
