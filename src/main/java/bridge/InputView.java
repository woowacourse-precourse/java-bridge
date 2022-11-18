package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String STRING_REGEX = "^[A-Z]*$";
    private static final String NUMBER_REGEX = "^[1-9]*$";
    private static final String REPLAY_GAME = "R";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validateBrideSize(input);
        return Integer.parseInt(input);
    }

    private static void validateBrideSize(String input) {
        if(!Pattern.matches(NUMBER_REGEX,input)){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validate(input);
        return input;
    }

    private static void validate(String input) {
        if(!Pattern.matches(STRING_REGEX,input)){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
