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
        try {
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return 0;
            // throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if (move.equals("U") || move.equals("D")) {
            return move;
        }

        throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        if (command.equals("R") || command.equals("Q")) {
            return command;
        }

        throw new IllegalArgumentException();
    }
}
