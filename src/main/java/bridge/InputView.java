package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final int minBridgeLength = 3;
    private final int maxBridgeLength = 20;
    private final String readBridgeSizeComment = "다리의 길이를 입력해주세요.";
    private final String moveErrorMessage = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있습니다.";
    private final String bridgeSizeErrorMessage = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        int bridgeLength = 0;
        do {
            System.out.println(readBridgeSizeComment);
            String bridgeLengthInput = Console.readLine();
            if (!isInteger(bridgeLengthInput)) continue;
            bridgeLength = Integer.parseInt(bridgeLengthInput);
        } while (!isCorrectRange(bridgeLength));
        System.out.println();
        return bridgeLength;
    }

    private boolean isCorrectRange(int bridgeLength) {
        try {
            if (bridgeLength >= 3 && bridgeLength <= 20) {
                return true;
            }
            throw new IllegalArgumentException(bridgeSizeErrorMessage);
        } catch (IllegalArgumentException e) {
            return errorCase(e);
        }
    }

    private boolean isInteger(String bridgeLengthInput) {
        try {
            if (bridgeLengthInput.chars().allMatch(Character::isDigit)) {
                return true;
            }
            throw new IllegalArgumentException(bridgeSizeErrorMessage);
        } catch (IllegalArgumentException e) {
            return errorCase(e);
        }
    }



    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveInput;
        do {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            moveInput = Console.readLine();

        } while (!isCorrectMove(moveInput));
        return moveInput;
    }

    private boolean isCorrectMove(String movingInput) {
        try {
            if (movingInput.equals("U") || movingInput.equals("D")) {
                return true;
            }
            throw new IllegalArgumentException(moveErrorMessage);
        } catch (IllegalArgumentException e) {
            return errorCase(e);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommandInput = Console.readLine();
        return gameCommandInput;
    }

    private boolean errorCase(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return false;
    }
}
