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
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String input = Console.readLine();
            validateBridgeSizeInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private void validateBridgeSizeInput(String bridgeSizeInput) throws IllegalArgumentException {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요!");
        }
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 값을 입력해주세요!");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = Console.readLine();
            validateMovingInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private void validateMovingInput(String movingInput) throws IllegalArgumentException {
        if (!(movingInput.equals("U") || movingInput.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해주세요!");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String input = Console.readLine();
            validateGameCommandInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void validateGameCommandInput(String gameCommandInput) throws IllegalArgumentException {
        if (!(gameCommandInput.equals("R") || gameCommandInput.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요!");
        }
    }
}