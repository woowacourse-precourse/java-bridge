package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int number = 0;

        number = this.getInteger();
        if (number >= 3 && number <= 20)
            return number;

        throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public int readMoving() {
        String line = Console.readLine();

        if (line.equals("U"))
            return 1;
        else if (line.equals("D"))
            return 0;
        throw new IllegalArgumentException("U 혹은 D를 입력해야 합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String line = Console.readLine();

        if (line.equals("R"))
            return true;
        else if (line.equals("Q"))
            return false;
        throw new IllegalArgumentException("R 혹은 Q를 입력해야 합니다.");
    }

    private int getInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
