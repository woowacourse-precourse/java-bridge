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
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        int bridgeSize;

        try {
            bridgeSize = checkNotInteger(input);
        } catch (IllegalArgumentException e) {
            System.out.println("");
            bridgeSize = readBridgeSize();
        }

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move;

        try {
            move = checkMove();
        } catch (IllegalArgumentException e) {
            System.out.println("");
            move = readMoving();
        }

        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command;

        try {
            command = checkCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("");
            command = readGameCommand();
        }

        return command;
    }

    private static int checkNotInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);

            if (!(element >= '0' && element <= '9'))
                throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    private static String checkMove() {
        String input = Console.readLine();
        char element = input.charAt(0);
        if (element == 'U' || element == 'D')
            return input;

        throw new IllegalArgumentException();
    }

    private static String checkCommand() {
        String input = Console.readLine();
        char element = input.charAt(0);
        if (element == 'Q' || element == 'R')
            return input;

        throw new IllegalArgumentException();
    }
}
