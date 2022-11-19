package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_LENGTH_MSG  = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_LENGTH_ERROR_MSG  = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String BRIDGE_SQUARE_MSG  = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String BRIDGE_SQUARE_ERROR_MSG  = "위: U, 아래: D 값을 입력해 주세요.";
    private static final String BRIDGE_RESTART_MSG  = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_MSG);
        String bridgeSize =  Console.readLine();
        try {
            validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(BRIDGE_SQUARE_MSG);
        String moveSquare =  Console.readLine();
        try {
            validateBridgeMoveSquare(moveSquare);
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
            return readMoving();
        }
        return moveSquare;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static void validateBridgeSize(String size) {
        boolean isNumeric = size.chars().allMatch( Character::isDigit );
        if (isNumeric != true || !(Integer.parseInt(size) >= 3 && Integer.parseInt(size) <=20)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERROR_MSG);
        }
    }

    private static void validateBridgeMoveSquare(String square) {
        if (square != "U" || square != "D") {
            throw new IllegalArgumentException(BRIDGE_SQUARE_ERROR_MSG);
        }
    }

}
