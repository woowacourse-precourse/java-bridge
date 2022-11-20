package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 1. InputView의 패키지는 변경할 수 🌴있다.🌴
 * 2. InputView의 메소드 시그니처 (인자, 이름)와 반환 타입은 변경할 수 🌴있다.🌴
 * 3. 사용자 값 입력을 위해 필요한 메소드를 추가할 수 🌴있다.🌴
 * 4. InputView 클래스에서만 Console.readLine() 메소드를 이용해 사용자의 입력을 받을 수 🌴있다.🌴
 */
public class InputView {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String NON_DIGIT_CHARACTER = "\\D";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
        final String input = Console.readLine();
        lineFeed();

        try {
            validateNumericType(input);
            validateRange(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static void lineFeed() {
        System.out.println();
    }

    private static void validateNumericType(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자 형태만 받을 수 있습니다.");
        }
    }

    private static void validateRange(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                            MINIMUM_BRIDGE_SIZE,
                            MAXIMUM_BRIDGE_SIZE
                    ));
        }
    }

    private static boolean isNotNumeric(String input) {
        return input.matches(NON_DIGIT_CHARACTER);
    }
}
