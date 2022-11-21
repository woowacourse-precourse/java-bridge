package bridge;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
//    public int readBridgeSize() {
//        try {
//            String size = Console.readLine();
//            return Integer.parseInt(size);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("[ERROR]: 3 - 20사이에 숫자만 가능합니다.", e);
//        }
//    }

    public int readBridgeSize() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movement = Console.readLine();
        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        return command;
    }
}
