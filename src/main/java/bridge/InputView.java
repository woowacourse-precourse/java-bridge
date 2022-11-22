package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String input = Console.readLine();
        int bridgeSize = inputToNumber(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("이동할 칸은 \"U\"또는 \"D\"를 입력해야 합니다.");
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("재시작/종료 여부는 \"R\"또는 \"Q\"를 입력해야 합니다.");
        }
        return input;
    }

    private int inputToNumber(String input) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        return number;
    }
}
