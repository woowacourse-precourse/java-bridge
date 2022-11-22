package bridge.handler;

import bridge.domain.bridge.Bridge;
import bridge.view.InputView;

public class InputHandler {
    private static final String INPUT_VALUE_LENGTH_ERROR = "[ERROR] 입력 값의 길이는 1이어야 합니다.";
    private static final String INPUT_BLOCK_TO_MOVE_ERROR = "[ERROR] 이동할 칸은 U 또는 D 중 하나의 문자여야 합니다.";
    private static final String INPUT_GAME_COMMAND_ERROR = "[ERROR] 게임 재시작/종료 값은 R 또는 Q 중 하나의 문자여야 합니다.";

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Bridge getBridgeSize() {
        try {
            String input = inputView.readBridgeSize();
            return new Bridge(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public String getBlockToMove() {
        try {
            String input = inputView.readMoving();
            validateBlockToMove(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBlockToMove();
        }
    }

    public String getGameCommand() {
        try {
            String input = inputView.readGameCommand();
            validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }

    private void validateBlockToMove(String input) {
        validateLength(input);
        validateCorrectBlock(input);
    }

    private void validateGameCommand(String input) {
        validateLength(input);
        validateCorrectCommand(input);
    }

    private void validateLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INPUT_VALUE_LENGTH_ERROR);
        }
    }

    private void validateCorrectBlock(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(INPUT_BLOCK_TO_MOVE_ERROR);
        }
    }

    private void validateCorrectCommand(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(INPUT_GAME_COMMAND_ERROR);
        }
    }
}
