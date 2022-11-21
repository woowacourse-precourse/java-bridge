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
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSizeInput = Console.readLine();
        try {
            isSizeInRange(validateNumeric(bridgeSizeInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }

        return Integer.parseInt(bridgeSizeInput);
    }

    public int validateNumeric(String bridgeSizeInput) throws IllegalArgumentException{
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return bridgeSize;
    }

    public boolean isSizeInRange(int bridgeSize) throws IllegalArgumentException {
        if (!(bridgeSize >= 3 && bridgeSize <= 20)) {
            throw new IllegalArgumentException("[ERROR] 3에서 20 사이의 숫자를 입력해주세요.");
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String directionInput = Console.readLine();

        return directionInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String doRetry = Console.readLine();

        return doRetry;
    }
}
