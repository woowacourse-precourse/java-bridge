package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final Integer MOV = 1;
    public static final Integer CMD = 2;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+") ||
                Integer.parseInt(input) < 3 ||
                Integer.parseInt(input) > 20)
            Err.WRONG_BRIDGE_LENGTH.invalid();
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    private String readMoving() throws IllegalArgumentException {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if (!input.equals("U") && !input.equals("D"))
            Err.WRONG_MOVE.invalid();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    private String readGameCommand() throws IllegalArgumentException {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        if (!input.equals("R") && !input.equals("Q"))
            Err.WRONG_RETRY_OR_TERMINATE.invalid();
        return input;
    }

    public String readString(Integer which) {
        if (which == MOV)
            return readMoving();
        return readGameCommand();
    }
}
