package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH_INTRO = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_INTRO);
        String input = Console.readLine();

        int convertedNumber = convertToNumber(input);
        validRange(convertedNumber);
        return convertedNumber;
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 값은 숫자로만 입력해주세요.");
            return readBridgeSize();
        }
    }

    public static void validRange(int convertedNumber) {
        if (convertedNumber < 3 || convertedNumber > 20) {
            throw new IllegalArgumentException("[ERROR] 값은 3 이상 20 이하 숫자만 가능합니다");
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputMoving = Console.readLine().trim();
        return validValue(inputMoving);
    }

    public static String validValue(String inputMoving) {
        try {
            if (!inputMoving.equals("D") && !inputMoving.equals("U")) {
                throw new IllegalArgumentException("[ERROR] 값은 D 혹은 U로만 입력이 가능합니다.");
            }
            return inputMoving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
