package bridge.view;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_INPUT_MSG);
        int result = BRIDGE_LENGTH_INPUT_ERROR;
        while (result == BRIDGE_LENGTH_INPUT_ERROR) {
            result = tryBridgeSizeInput();
        }
        return result;
    }

    private int tryBridgeSizeInput() {
        try {
            String bridgeLengthInput = Console.readLine();
            Validation.checkBridgeSizeInput(bridgeLengthInput);
            return Integer.parseInt(bridgeLengthInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return BRIDGE_LENGTH_INPUT_ERROR;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT_MSG);
        String result = BRIDGE_MOVE_INPUT_ERROR;
        while (result.equals(BRIDGE_MOVE_INPUT_ERROR)) {
            result = tryMoveInput();
        }
        return result;
    }

    private String tryMoveInput() {
        try {
            String moveCommandInput = Console.readLine();
            Validation.checkMoveCommand(moveCommandInput);
            return moveCommandInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return BRIDGE_MOVE_INPUT_ERROR;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_RESTART_MSG);
        String result = GAME_COMMAND_INPUT_ERROR;
        while (result.equals(GAME_COMMAND_INPUT_ERROR)) {
            result = tryGameCommandInput();
        }
        return result;
    }

    private String tryGameCommandInput() {
        try {
            String gameCommandInput = Console.readLine();
            Validation.checkGameCommand(gameCommandInput);
            return gameCommandInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return GAME_COMMAND_INPUT_ERROR;
    }
}