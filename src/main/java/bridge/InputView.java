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
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            String bridgeSizeInput = Console.readLine();
            try {
                return validateBridgeSize(bridgeSizeInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String movingInput = Console.readLine();
            try {
                return validateMovingInput(movingInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String regameInput = Console.readLine();
            try {
                return validateRegameInput(regameInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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

    private String validateMovingInput(String movingInput) {
        if (!(movingInput.equals("U") || movingInput.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] \"위: U, 아래: D\"만 입력 가능합니다.");
        }
        return movingInput;
    }

    private String validateRegameInput(String regameInput) {
        if (!(regameInput.equals("R") || regameInput.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] \"재시도: R, 종료: Q\"만 입력 가능합니다.");
        }
        return regameInput;
    }
}
