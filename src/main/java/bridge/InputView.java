package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws NumberFormatException{
        System.out.println(ConstString.INPUT_SIZE);
        String input = Console.readLine();
        int ret;
        try{
            ret = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(ConstString.INPUT_SIZE_ERROR);
        }
        return ret;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        System.out.println(ConstString.CHOOSE_STEP);
        String input = Console.readLine();
        if (!(input.equals(ConstString.UP) || input.equals(ConstString.DOWN))) {
            throw new IllegalArgumentException(ConstString.INPUT_MOVE_ERROR);
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException{
        System.out.println(ConstString.RETRY_OR_QUIT);
        String input = Console.readLine();
        if (!input.equals(ConstString.RETRY) && !input.equals(ConstString.QUIT)) {
            throw new IllegalArgumentException(ConstString.INPUT_RETRY_OR_QUIT_ERROR);
        }
        return input;
    }
}
