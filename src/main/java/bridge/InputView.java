package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            int n = Integer.parseInt(Console.readLine());
            if (n < 3 || n > 20) {
                throw new IllegalArgumentException();
            }
            return n;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3 이상 20 이하의 숫자만 입력가능합니다.");
            return -1;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userChoice = String.valueOf(Console.readLine().charAt(0));
        try {
            if (!(userChoice.equals("U") || userChoice.equals("D"))) {
                throw new IllegalArgumentException("[ERROR] 이동할 칸의 입력은 U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "-1";
        }
        return userChoice;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String command = String.valueOf(Console.readLine().charAt(0));
        try {
            if (!(command.equals("R") || command.equals("Q"))) {
                throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 여부의 입력은 R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "-1";
        }

        return command;
    }
}
