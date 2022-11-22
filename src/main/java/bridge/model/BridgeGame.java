package bridge.model;

import java.util.List;

import static bridge.controller.BridgeController.upAndDown;

public class BridgeGame {

    private final UserInput userInput;

    public BridgeGame() {
        this.userInput = new UserInput();
    }

    public int move(List<String> bridges, int count, String inputMoving) {
        userInput.validateInputMoving(inputMoving);
        if (inputMoving.equals("U") && bridges.get(count).equals("U")) {
            isUAndU();
            return count;
        }
        return getCountNotUAndU(bridges, count, inputMoving);
    }

    private int getCountNotUAndU(List<String> bridges, int count, String inputMoving) {
        if (inputMoving.equals("U") && bridges.get(count).equals("D")) {
            isUAndD();
            return 21;
        }
        return getCountNotUAndD(bridges, count, inputMoving);
    }

    private int getCountNotUAndD(List<String> bridges, int count, String inputMoving) {
        if (inputMoving.equals("D") && bridges.get(count).equals("D")) {
            isDAndD();
        }
        if (inputMoving.equals("D") && bridges.get(count).equals("U")) {
            isDAndU();
            count = 21;
        }
        return count;
    }

    private void isDAndU() {
        upAndDown.get(0).add("   ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add(" X ");
        upAndDown.get(1).add("|");
    }

    private void isDAndD() {
        upAndDown.get(0).add("   ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add(" O ");
        upAndDown.get(1).add("|");
    }

    private void isUAndD() {
        upAndDown.get(0).add(" X ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add("   ");
        upAndDown.get(1).add("|");
    }

    private void isUAndU() {
        upAndDown.get(0).add(" O ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add("   ");
        upAndDown.get(1).add("|");
    }

    public String retry(String restartOrEnd) {
        userInput.validateRestartOrEnd(restartOrEnd);
        if (restartOrEnd.equals("Q")) {
            return "실패";
        }
        return "";
    }
}
