package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printInputBridgeSizeMessage();
        String bridgeSize = Console.readLine();

        while (tryValidateBridge(bridgeSize)) {
            printReInputBridgeSizeMessage();
            bridgeSize = Console.readLine();
        }

        return Integer.parseInt(bridgeSize);
    }

    private void printInputBridgeSizeMessage() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }

    private void printReInputBridgeSizeMessage() {
        System.out.println();
        System.out.println("다리의 길이를 다시 입력해주세요.");
    }

    private boolean tryValidateBridge(String bridgeSize) {
        try {
            validateBridge(bridgeSize);
        } catch (IllegalArgumentException illegalArgumentException) {
            return true;
        }

        return false;
    }

    private boolean validateBridge(String bridgeSize) {
        if (validateBridgeCharacter(bridgeSize) || validateBridgeRange(bridgeSize)) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

        return false;
    }

    private boolean validateBridgeCharacter(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(Character::isDigit)) {
            return true;
        }

        return false;
    }

    private boolean validateBridgeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            return true;
        }

        return false;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
