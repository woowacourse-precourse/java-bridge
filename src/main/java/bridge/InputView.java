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
        String size = Console.readLine();
        char[] chars = size.toCharArray();

        for (char aChar : chars) {
            if(!(0 <= aChar - '0' &&  9>= aChar - '0')) {
                throw new IllegalArgumentException("[ERROR] Invalid input");
            }
        }

        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if(!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] invalid input not U or D");
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String quit =  Console.readLine();

        if(!(quit.equals("Q") || quit.equals("R"))) {
            throw new IllegalArgumentException("[ERROR] invalid input not Q or R");
        }
        return quit;
    }
}
