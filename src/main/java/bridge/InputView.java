package bridge;

import bridge.message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = readInteger();
        if(size >= 3 && size <= 20)
            return size;

        throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_OUT_RANGE.value);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = readOneCharacter();
        if(moving.equals("U") || moving.equals("D"))
            return moving;

        throw new IllegalArgumentException(ErrorMessage.INPUT_UD.value);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String moving = readOneCharacter();
        if(moving.equals("R") || moving.equals("Q"))
            return moving;

        throw new IllegalArgumentException(ErrorMessage.INPUT_RQ.value);
    }

    private int readInteger() {
        try {
            int number = Integer.parseInt(Console.readLine());
            return number;
        } catch(Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INTEGER.value);
        }
    }

    private String readOneCharacter() {
        String line;
        try {
            line = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.value);
        }
        if(line.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONE_CHARACTER.value);
        }
        return line;
    }
}
