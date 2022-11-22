package bridge;

import camp.nextstep.edu.missionutils.Console;
import message.InputMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MINIMUM_NUMBER = 3;

    private static final int MAXIMUM_NUMBER = 20;

    private static final String UP = "U";

    private static final String DONW = "D";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            InputMessage.print(InputMessage.INPUT_BRIDGE_LENGTH);
            int number = toInt(Console.readLine());
            validateNumberRange(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            throw e;
        }
    }

    private int toInt(String strNumber) {
        validateInt(strNumber);
        return Integer.parseInt(strNumber);
    }


    private void validateNumberRange(int number) {
        if (MINIMUM_NUMBER > number || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 3과 20사이의 숫자가 아닙니다");
        }
    }

    private void validateInt(String word) {
        if (!word.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다");
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        InputMessage.print(InputMessage.INPUT_MOVE_SIDE);
        String input = Console.readLine();
        try {
            validateReadMoving(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return input;
    }

    private void validateReadMoving(String word) {
        if (!word.equals(InputMessage.UP) && !word.equals(InputMessage.DONW)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D가 입력되지 않았습니다");
        }

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        InputMessage.print(InputMessage.INPUT_GAME_RESTART);
        String input = Console.readLine();
        try {
            validateReadGameCommand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    private void validateReadGameCommand(String word) {
        if (!word.equals(InputMessage.REGAME) && !word.equals(InputMessage.QUIT)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q가 입력되지 않았습니다");
        }
    }
}
