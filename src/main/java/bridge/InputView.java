package bridge;

import bridge.constant.ErrorMessage;
import bridge.constant.Game;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println(Game.INPUT_BRIDGE_SIZE);
        int result = validateSize(Console.readLine());
        if (result < Game.MIN_SIZE || result > Game.MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_SIZE);
        }
        return result;
    }

    public String readMoving() {
        System.out.println(Game.INPUT_DIRECTION);
        return validateMoving(Console.readLine());
    }

    public String readGameCommand() {
        return validateCommend(Console.readLine());
    }

    private String validateCommend(String commend) {
        if (!(commend.equals("R") || commend.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_COMMEND);
        }
        return commend;
    }

    private int validateSize(String size) {
        for (int i = 0; i < size.length(); i++) {
            if (!(size.charAt(i) <= '9' && size.charAt(i) >= '0')) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER);
            }
        }
        return Integer.parseInt(size);
    }

    private String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_DIRECTION);
        }
        return moving;
    }
}
