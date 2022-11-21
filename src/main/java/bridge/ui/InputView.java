package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

import static bridge.util.Constant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        int bridgeSize;
        bridgeSize = checkNumeralInput(bridgeSizeInput);
        isValidBridgeSize(bridgeSize);

        return bridgeSize;
    }

    public String readMoving() {
        String blockInput = Console.readLine();
        isValidBlockInput(blockInput);
        return blockInput;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        isValidGameCommand(gameCommand);
        return gameCommand;
    }

    private int checkNumeralInput(String bridgeSizeInput) {
        try {
            return Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자가 입력되어야 합니다.");
        }
    }

    private void isValidBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_LENGTH || bridgeSize > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void isValidBlockInput(String block) {
        if (!block.equals(MOVING_UP) && !block.equals(MOVING_DOWN)) {
            throw new IllegalArgumentException("[ERROR] 이동 시에는 U or D 의 문자가 입력되어야 합니다.");
        }
    }

    private void isValidGameCommand(String gameCommand) {
        if (!gameCommand.equals(QUIT_GAME) && !gameCommand.equals(RETRY_GAME)) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 여부에는 R or Q 의 문자가 입력되어야 합니다.");
        }
    }
}
