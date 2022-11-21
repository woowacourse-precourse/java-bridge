package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static String start = "다리 건너기 게임을 시작합니다.";
    private final static String redBridgeSize = "다리의 길이를 입력해주세요.";
    private final static String redBridgeSizeError = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final static String readMoving = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String readMovingError = "[ERROR] U, D 중 하나를 입력해야 합니다.";
    private final static String readGameCommand = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String readGameCommandError = "[ERROR] R, Q 중 하나를 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        System.out.println(redBridgeSize);
        String input = Console.readLine();
        int result = Integer.parseInt(input);
        if(result < 3 || result > 20){
            System.out.println(redBridgeSizeError);
            throw new IllegalArgumentException();
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(readMoving);
        String result = Console.readLine();
        if(!(result.contains("U") || result.contains("D"))){
            System.out.println(readMovingError);
            throw new IllegalArgumentException();
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(readGameCommand);
        String result = Console.readLine();
        if(!(result.contains("R") || result.contains("Q"))){
            System.out.println(readGameCommandError);
            throw new IllegalArgumentException();
        }
        return result;
    }
}
