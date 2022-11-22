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
        while (true) {
            try {
                int size = inputBridgeSize();
                if (size >=3 && size <= 20) {
                    return size;
                } throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    public static int inputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요");
        String input = Console.readLine();
        int size = Integer.parseInt(input);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while (true) {
            try {
                String move = inputMoving();
                if (move.equals("U") || move.equals("D")) {
                    return move;
                } throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 이동할 칸은 U(위 칸) 또는 D(아래 칸)여야 합니다.");
            }
        }
    }

    public static String inputMoving() {
        System.out.println("이동할 칸을 입력해주세요. (위 : U, 아래 : D)");
        String move = Console.readLine();
        return move;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        while (true) {
            try {
                String command = inputGameCommand();
                if (command.equals("R") || command.equals("Q")) {
                    return command;
                } throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] R(재시도) 또는 Q(종료)를 입력해 주세요.");
            }
        }
    }

    public static String inputGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        return gameCommand;
    }

}
