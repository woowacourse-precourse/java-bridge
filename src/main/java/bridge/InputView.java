package bridge;

import camp.nextstep.edu.missionutils.Console;
import message.ErrorMessage;

import static message.ErrorMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                int bridgeSize = checkBridgeSize(checkString(Console.readLine()));
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_ERROR.getMessage());
        }
        return bridgeSize;
    }

    public int checkString(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(TYPE_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            String upOrDown = Console.readLine();
            try {
                checkMoving(upOrDown);
                return upOrDown;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void checkMoving(String upOrDown) {
        if (!(upOrDown.equals("U") || upOrDown.equals("D"))) {
            throw new IllegalArgumentException(MOVING_ERROR.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String retryOrNot = checkGameCommand(Console.readLine());
                return retryOrNot;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String checkGameCommand(String retryOrNot) {
        if (!(retryOrNot.equals("R") || retryOrNot.equals("Q"))) {
            throw new IllegalArgumentException(RETRY_INPUT_ERROR.getMessage());
        }
        return retryOrNot;
    }
}
