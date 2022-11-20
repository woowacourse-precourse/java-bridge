package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    PrintCommand printCommand = new PrintCommand();
    Validator validate = new Validator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeLength;

        printCommand.getBridgeLength();
        try {
            bridgeLength = Integer.valueOf(Console.readLine());
        } catch (NumberFormatException error) {
//            throw new IllegalArgumentException(ERROR_MESSAGE);
            System.out.println(ERROR_MESSAGE);
            bridgeLength=0;
        }
//        validate.bridgeLengthRange(bridgeLength);

        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movement;
        printCommand.getMovement();
        movement= Console.readLine();
        validate.isUpOrDown(movement);
        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
