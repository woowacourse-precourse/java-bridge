package bridge.view;

import bridge.domain.Command;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            String size = readLine();
            return Integer.parseInt(size);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이에 대한 입력이 잘못되었습니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String move = readLine();

        if (!(move.equals("D") || move.equals("U")))
            throw new IllegalArgumentException("이동할 칸에 대한 입력이 잘못되었습니다.");

        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static Command readGameCommand() {
        String command = readLine();

        if (!(command.equals("R") || command.equals("Q")))
            throw new IllegalArgumentException("재시작 옵션 대한 입력이 잘못되었습니다.");

        if (command.equals("R"))
            return Command.RESTART;

        return Command.QUIT;
    }
}
