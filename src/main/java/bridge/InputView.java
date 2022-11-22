package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NOT_RANGE_NUM = "[ERROR] 3 이상 20 이하의 값을 입력해주세요.";
    private static final String NOT_ONLY_NUM = "[ERROR] 숫자만 입력해주세요.";
    private static final String NOT_UP_DOWN = "[ERROR] U, D 중에 하나만 입력해주세요.";
    private static final String NOT_RE_QUIT = "[ERROR] R, Q 중에 하나만 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        final String REGEX = "[0-9]+";

        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();

        if(bridgeSize.matches(REGEX) == false){
            System.out.println(NOT_ONLY_NUM);
            readBridgeSize();
//            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(bridgeSize) <3 || Integer.parseInt(bridgeSize) > 20) {
            System.out.println(NOT_RANGE_NUM);
            readBridgeSize();
//            throw new IllegalArgumentException();
        }

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String bridgeMoving = Console.readLine();
        if (!bridgeMoving.equals("U") && !bridgeMoving.equals("D")) {
            System.out.println(NOT_UP_DOWN);
            readMoving();
//            throw new IllegalArgumentException();
        }
        return bridgeMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String reOrStop = Console.readLine();
        if (!reOrStop.equals("R") && !reOrStop.equals("Q")) {
            System.out.println(NOT_RE_QUIT);
            readGameCommand();
//            throw new IllegalArgumentException();
        }
        return reOrStop;
    }
}
