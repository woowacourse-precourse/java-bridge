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
        // TODO : 예외 발생 시 다시 받기
        return validateBridgeSize(bridgeSizeInput);
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

    private int validateBridgeSize(String bridgeSizeInput) {
        if (!bridgeSizeInput.matches(RegValue.ONLY_NUMBER.getReg())) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(bridgeSizeInput) < 3 || Integer.parseInt(bridgeSizeInput) > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(bridgeSizeInput);
    }
}
