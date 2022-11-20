package bridge;

import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String bridgeSizeInputExceptionMessage = " 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String moveInputExceptionMessage = " U와 D 중 하나만 입력하세요.";
    private static final String gameRetryInputExceptionMessage = " R과 Q 중 하나만 입력하세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해 주세요.");
        int bridgeSize = validateBridgeSizeInput(Console.readLine());
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = validateMoveInput(Console.readLine());
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = validateGameRetry(Console.readLine());
        return input;
    }

    private int validateBridgeSizeInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(bridgeSizeInputExceptionMessage);
        }
        int intInput = Integer.parseInt(input);
        if (3 > intInput || 20 < intInput) {
            throw new IllegalArgumentException(bridgeSizeInputExceptionMessage);
        }
        return intInput;
    }

    private String validateMoveInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(moveInputExceptionMessage);
        }
        return input;
    }

    private String validateGameRetry(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(gameRetryInputExceptionMessage);
        }
        return input;
    }
}
