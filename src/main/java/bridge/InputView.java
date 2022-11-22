package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_SIZE_RANGE1 = 3;
    private static final int BRIDGE_SIZE_RANGE2 = 20;

    private Validation validation = new Validation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputString.BRIDGE_SIZE_INPUT_MESSAGE.InputMessage());
        int input = Integer.valueOf(Console.readLine());
        if (!(validation.SizeRangeValidate(input, BRIDGE_SIZE_RANGE1, BRIDGE_SIZE_RANGE2))) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputString.MOVE_INPUT_MESSAGE.InputMessage());
        String input = Console.readLine();
        if (!validation.CharValidate(input, InputString.USER_MOVE_UP.InputMessage(), InputString.USER_MOVE_DOWN.InputMessage())) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n" + InputString.GAME_RETRY_INPUT_MESSAGE.InputMessage());
        String input = Console.readLine();
        if (!validation.CharValidate(input, InputString.USER_RETRY.InputMessage(), InputString.USER_OVER.InputMessage())) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
