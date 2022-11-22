package bridge.domain;

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
        String inputBridgeSize = Console.readLine();
        try {
            validateInputBridgeSize(inputBridgeSize);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return Integer.valueOf(inputBridgeSize);
    }

    public void validateInputBridgeSize(String inputBridgeSize) {
        final String errorMsg = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
        if (inputBridgeSize.isEmpty() || inputBridgeSize.length() > 2) {
            throw new IllegalArgumentException(errorMsg);
        }
        if (inputBridgeSize.length() == 2 && !Character.isDigit(inputBridgeSize.charAt(1))) {
            throw new IllegalArgumentException(errorMsg);
        }
        if (!Character.isDigit(inputBridgeSize.charAt(0)) || !inRange(inputBridgeSize)) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private boolean inRange(String inputBridgeSize) {
        return Integer.valueOf(inputBridgeSize) >= 3 && Integer.valueOf(inputBridgeSize) <= 20;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputMoving = Console.readLine();
        try {
            validateInputReadMoving(inputMoving);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return inputMoving;
    }

    private void validateInputReadMoving(String inputMoving) {
        if (!inputMoving.equals("U") && !inputMoving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 (위: U, 아래: D) 둘 중 하나여야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputGameCommand = Console.readLine();
        try {
            validateReadGameCommand(inputGameCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return inputGameCommand;
    }

    private void validateReadGameCommand(String inputGameCommand) {
        if (!inputGameCommand.equals("R") && !inputGameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임을 다시 시도할지 여부는 (재시도: R, 종료: Q) 둘 중 하나여야 합니다.");
        }
    }
}
