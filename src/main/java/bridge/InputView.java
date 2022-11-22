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
        return validateBridgeSize(Console.readLine());
    }

    private int validateBridgeSize(String string) {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자열이 정수가 아닙니다.");
        }
        if (bridgeSize < 3 || 20 < bridgeSize) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String moving = Console.readLine();

        validateReadMoving(moving);

        return moving;
    }

    private void validateReadMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 여야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String gameCommand = Console.readLine();

        validateGameCommand(gameCommand);

        return gameCommand;
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임을 다시 시도할지 여부는 R 또는 Q 여야 합니다.");
        }
    }
}
