package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.System.out;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        out.println();

        Integer inputInt= Integer.parseInt(input);
        return inputInt;
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        return input;
    }
}