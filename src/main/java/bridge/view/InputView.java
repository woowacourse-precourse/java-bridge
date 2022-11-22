package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static int bridgeSize;
    private static String moveDirection;
    private static String gameCommand;
    public int readBridgeSize() {
        bridgeSize = Integer.parseInt(Console.readLine());
        validateSizeNumber(bridgeSize);
        return bridgeSize;
    }

    public String readMoving() {
        moveDirection = Console.readLine();
        validateMoveDirection(moveDirection);
        return moveDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    public void validateSizeNumber(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상 20 이하만 가능합니다.");
        }
    }

    public void validateMoveDirection(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동 방향은 위(U), 아래(D)만 가능합니다.");
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q 입니다.");
        }
    }

}
