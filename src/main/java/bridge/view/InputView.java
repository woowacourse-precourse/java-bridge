package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String REGEX_NUMBER = "^[0-9]*$";
    private static final String REGEX_MOVING = "^D|U$";
    private static final String REGEX_GAME_COMMAND = "^R|Q$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateBridgeSizeInput(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private void validateBridgeSizeInput(String bridgeSize) {
        if (!bridgeSize.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력은 3~20 사이의 숫자만 가능합니다!");
        }
        int bridgeSizeNumber = Integer.parseInt(bridgeSize);
        if (bridgeSizeNumber < 3 || bridgeSizeNumber > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력은 3~20 사이의 숫자만 가능합니다!");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    private void validateMoving(String moving) {
        if (!moving.matches(REGEX_MOVING)) {
            throw new IllegalArgumentException("[ERROR] 사용자가 이동할 칸은 'D', 'U' 중 하나를 선택해야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches(REGEX_GAME_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작 여부는 'R', 'Q' 중 하나를 선택해야 합니다.");
        }
    }
}
