package bridge.view;

import bridge.SafeBridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 1. InputView의 패키지는 변경할 수 🌴있다.🌴
 * 2. InputView의 메소드 시그니처 (인자, 이름)와 반환 타입은 변경할 수 🌴있다.🌴
 * 3. 사용자 값 입력을 위해 필요한 메소드를 추가할 수 🌴있다.🌴
 * 4. InputView 클래스에서만 Console.readLine() 메소드를 이용해 사용자의 입력을 받을 수 🌴있다.🌴
 */
public class InputView {
    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_DIRECTION = String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", "U", "D");
    private static final String ASK_RETRY = String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", "R", "Q");
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
        final String input = Console.readLine();
        try {
            InputValidator.bridgeSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        lineFeed();
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(ENTER_DIRECTION);
        final String input = Console.readLine();
        try {
            InputValidator.moving(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return input.toUpperCase();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        // 질문이랑 입력값 메소드로 분리
        System.out.println(ASK_RETRY);
        final String input = Console.readLine();
        try {
            InputValidator.gameCommand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input.toUpperCase();
    }

    private static void lineFeed() {
        System.out.println();
    }
}
