package bridge.UI.input;

import bridge.UI.output.OutputView;
import bridge.enums.Announcement;
import bridge.enums.Direction;
import bridge.enums.GameCommand;
import bridge.exception.BridgeSizeException;
import bridge.exception.DirectionException;
import bridge.exception.GameCommandException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView;
    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = null;
        while (input == null) {
            try {
                input = inputBridgeSize();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return Integer.parseInt(input);
    }
    private String inputBridgeSize() {
        try {
            outputView.printSpaceLineAndMessage(Announcement.INPUT_BRIDGE_SIZE.getMessage());
            String input = Console.readLine();
            validateInteger(input);
            validateBridgeRange(input);
            return input;
        } catch (NumberFormatException | BridgeSizeException exception) {
            throw new BridgeSizeException(new IllegalArgumentException().getMessage());
        }
    }
    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException();
        }
    }
    private void validateBridgeRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 3 || 20 < inputNumber) {
            throw new BridgeSizeException(input);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        String input = null;
        while (input == null) {
            try {
                input = inputMoving();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return Direction.find(input);
    }
    private String inputMoving() {
        try {
            outputView.printSpaceLineAndMessage(Announcement.INPUT_MOVING_DIRECTION.getMessage(), Direction.getGuide());
            String input = Console.readLine();
            validateMoving(input);
            return input;
        } catch (IllegalArgumentException e) {
            throw new DirectionException(new IllegalArgumentException().getMessage(), Direction.getGuide());
        }
    }
    private void validateMoving(String input) {
        if (!Direction.contains(input)) {
            throw new DirectionException(new IllegalArgumentException().getMessage(), Direction.getGuide());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() throws GameCommandException {
        String input = null;
        while (input == null) {
            try {
                input = inputGameCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return GameCommand.find(input);
    }
    private String inputGameCommand() {
        try {
            outputView.printSpaceLineAndMessage(Announcement.INPUT_RETRY_OR_QUIT.getMessage(), GameCommand.getGuide());
            String input = Console.readLine();
            validateGameCommand(input);
            return input;
        } catch (Exception e) {
            throw new DirectionException(new IllegalArgumentException().getMessage(), Direction.getGuide());
        }
    }
    private void validateGameCommand(String input) {
        if (!GameCommand.contains(input)) {
            throw new GameCommandException(new IllegalArgumentException().getMessage(), GameCommand.getGuide());
        }
    }
}
