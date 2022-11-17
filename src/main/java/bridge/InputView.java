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
            try {
                String bridgeSize = Console.readLine();
                validateBridgeSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
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
            try {
                String moving = Console.readLine();
                validateMoving(moving);
                return moving;
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
            try {
                String gameCommand = Console.readLine();
                validateGameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 값이어야 합니다.");
        }
    }

    private void validateMoving(String moving) {
        if (!moving.matches("[UD]")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 이어야 합니다.");
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches("[RQ]")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R 또는 Q 이어야 합니다.");
        }
    }
}
