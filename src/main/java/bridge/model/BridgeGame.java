package bridge.model;

import bridge.model.enumeration.Command;

import java.util.List;

import static bridge.controller.BridgeController.upAndDown;

public class BridgeGame {

    private final String FAIL = "실패";
    private final int MAX_LENGTH_PLUS_ONE = 21;
    private final UserInput userInput;

    public BridgeGame() {
        this.userInput = new UserInput();
    }

    public int move(List<String> bridges, int count, String inputMoving) {
        userInput.validateInputMoving(inputMoving);
        if (inputMoving.equals(Command.UP.getMessage()) && bridges.get(count).equals(Command.UP.getMessage())) {
            isUAndU();
        }
        if (inputMoving.equals(Command.UP.getMessage()) && bridges.get(count).equals(Command.DOWN.getMessage())) {
            isUAndD();
            return MAX_LENGTH_PLUS_ONE;
        }
        return getCountNotU(bridges, count, inputMoving);
    }

    private int getCountNotU(List<String> bridges, int count, String inputMoving) {
        if (inputMoving.equals(Command.DOWN.getMessage()) && bridges.get(count).equals(Command.DOWN.getMessage())) {
            isDAndD();
        }
        if (inputMoving.equals(Command.DOWN.getMessage()) && bridges.get(count).equals(Command.UP.getMessage())) {
            isDAndU();
            count = MAX_LENGTH_PLUS_ONE;
        }
        return count;
    }

    private void isDAndU() {
        upAndDown.get(0).add(Command.BLANK.getMessage());
        upAndDown.get(0).add(Command.BAR.getMessage());
        upAndDown.get(1).add(Command.IMPOSSIBLE.getMessage());
        upAndDown.get(1).add(Command.BAR.getMessage());
    }

    private void isDAndD() {
        upAndDown.get(0).add(Command.BLANK.getMessage());
        upAndDown.get(0).add(Command.BAR.getMessage());
        upAndDown.get(1).add(Command.POSSIBLE.getMessage());
        upAndDown.get(1).add(Command.BAR.getMessage());
    }

    private void isUAndD() {
        upAndDown.get(0).add(Command.IMPOSSIBLE.getMessage());
        upAndDown.get(0).add(Command.BAR.getMessage());
        upAndDown.get(1).add(Command.BLANK.getMessage());
        upAndDown.get(1).add(Command.BAR.getMessage());
    }

    private void isUAndU() {
        upAndDown.get(0).add(Command.POSSIBLE.getMessage());
        upAndDown.get(0).add(Command.BAR.getMessage());
        upAndDown.get(1).add(Command.BLANK.getMessage());
        upAndDown.get(1).add(Command.BAR.getMessage());
    }

    public String retry(String restartOrEnd) {
        userInput.validateRestartOrEnd(restartOrEnd);
        if (restartOrEnd.equals(Command.QUIT.getMessage())) {
            return FAIL;
        }
        return "";
    }
}
