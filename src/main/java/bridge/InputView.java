package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        try {
            return ValidateInput.validateBridgeSize(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            return ValidateInput.validateMoving(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "\"U\"(위) 또는 \"D\"(아래)를 입력해야 합니다.");
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        try {
            return ValidateInput.validateGameCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "\"R\"(재시도) 또는 \"Q\"(종료)를 입력해야 합니다.");
            return readGameCommand();
        }
    }
}
