package bridge.model;

import bridge.model.constants.Command;

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
        if (inputMoving.equals(Command.UP) && bridges.get(count).equals(Command.UP)) {
            isUAndU();
        }
        if (inputMoving.equals(Command.UP) && bridges.get(count).equals(Command.DOWN)) {
            isUAndD();
            return MAX_LENGTH_PLUS_ONE;
        }
        return getCountNotU(bridges, count, inputMoving);
    }

    private int getCountNotU(List<String> bridges, int count, String inputMoving) {
        if (inputMoving.equals(Command.DOWN) && bridges.get(count).equals(Command.DOWN)) {
            isDAndD();
        }
        if (inputMoving.equals(Command.DOWN) && bridges.get(count).equals(Command.UP)) {
            isDAndU();
            count = MAX_LENGTH_PLUS_ONE;
        }
        return count;
    }

    private void isDAndU() {
        upAndDown.get(0).add(Command.BLANK);
        upAndDown.get(0).add(Command.BAR);
        upAndDown.get(1).add(Command.IMPOSSIBLE);
        upAndDown.get(1).add(Command.BAR);
    }

    private void isDAndD() {
        upAndDown.get(0).add(Command.BLANK);
        upAndDown.get(0).add(Command.BAR);
        upAndDown.get(1).add(Command.POSSIBLE);
        upAndDown.get(1).add(Command.BAR);
    }

    private void isUAndD() {
        upAndDown.get(0).add(Command.IMPOSSIBLE);
        upAndDown.get(0).add(Command.BAR);
        upAndDown.get(1).add(Command.BLANK);
        upAndDown.get(1).add(Command.BAR);
    }

    private void isUAndU() {
        upAndDown.get(0).add(Command.POSSIBLE);
        upAndDown.get(0).add(Command.BAR);
        upAndDown.get(1).add(Command.BLANK);
        upAndDown.get(1).add(Command.BAR);
    }

    public String retry(String restartOrEnd) {
        userInput.validateRestartOrEnd(restartOrEnd);
        if (restartOrEnd.equals(Command.QUIT)) {
            return FAIL;
        }
        return "";
    }
}
