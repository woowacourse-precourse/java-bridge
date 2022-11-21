package bridge.view;

import bridge.exception.InputError;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        return parseToNumber(Console.readLine());
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

    private int parseToNumber(String input) {
        validateNumberFormat(input);
        int size = Integer.parseInt(input);

        if(size<3 || 20<size)
            throw new IllegalArgumentException(InputError.INVALID_NUMBER_RANGE.getMessage());

        return size;
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(InputError.NOT_A_NUMBER.getMessage());
        }
    }
}
