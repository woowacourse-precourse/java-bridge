package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = validateBridgeSizeInput(Console.readLine());
        validateBridgeSizeRange(bridgeSize);

        return bridgeSize;
    }

    private int validateBridgeSizeInput(String bridgeSizeInput) {
        try {
            return Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveTo = Console.readLine();
        validateMoveTo(moveTo);

        return moveTo;
    }

    private void validateMoveTo(String moveTo) {
        if (!(moveTo.contains("U") || moveTo.contains("D"))) {
            throw new IllegalArgumentException("[ERROR] U, D 둘 중 하나만 입력해주세요.");
        }

        if (moveTo.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 한 글자만 입력해주세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryStatus = Console.readLine();
        validateRetryStatus(retryStatus);

        return retryStatus;
    }

    private void validateRetryStatus(String retryStatus) {
        if (!(retryStatus.contains("R") || retryStatus.contains("Q"))) {
            throw new IllegalArgumentException("[ERROR] R, Q 둘 중 하나만 입력해주세요.");
        }

        if (retryStatus.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 한 글자만 입력해주세요.");
        }
    }
}
