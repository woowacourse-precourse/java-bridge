package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Exceptions.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = isNum(inputBridgeLength());
        return stringToInt(input);
    }

    public String inputBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String uOrD = isUOrD(inputMoving());
        return uOrD;
    }

    public String inputMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String rOrQ = isROrQ(inputRetry());
        return rOrQ;
    }

    public String inputRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String answer = Console.readLine();
        return answer;
    }

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
