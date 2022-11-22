package bridge.view;

import bridge.vo.Direction;
import camp.nextstep.edu.missionutils.Console;

import static bridge.Validator.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String INPUT_NOT_NUMBER_ERROR = "[ERROR] 다리 길이는 자연수만 입력 가능합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            validateBridge(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_NOT_NUMBER_ERROR);
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        String input = Console.readLine();
        validateDirection(input);
        return Direction.findByValue(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }
}