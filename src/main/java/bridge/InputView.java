package bridge;

import static bridge.OutputView.String;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.String("다리의 길이를 입력해주세요.");
        int result = Integer.parseInt(Console.readLine());
        if (result < 3 || result > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String string = Console.readLine().toUpperCase();
        if (!(string.equals("U") || string.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
        return string;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String string = Console.readLine().toUpperCase();
        System.out.println(string);
        if (!(string.equals("R") || string.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
        return string;
    }
}
