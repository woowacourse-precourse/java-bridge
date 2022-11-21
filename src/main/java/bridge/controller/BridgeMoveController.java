package bridge.controller;

import bridge.BridgeMove;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BridgeMoveController {

    private final List<String> bridge;
    private List<String> upperBridgeMove = new ArrayList<>();
    private List<String> lowerBridgeMove = new ArrayList<>();

    public BridgeMoveController(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String>[] run() {
        runBuildBridgeMove();
        List<String>[] bridgeMove = new ArrayList[2];
        bridgeMove[0] = upperBridgeMove;
        bridgeMove[1] = lowerBridgeMove;
        return bridgeMove;
    }

    private void runBuildBridgeMove() {
        int location = 0;
        String correct = "O";
        while (location < bridge.size() && correct.equals("O")) {
            correct = checkCorrectAndBuildBridge(location++);
        }
    }

    private String checkCorrectAndBuildBridge(int location) {
        String upDown = readMoving().getMove();
        String correct = "X";
        if (checkMove(location, upDown)) {
            correct = "O";
        }
        addBridgeAndPrintMap(location, upDown, correct);
        return correct;
    }

    private void addBridgeAndPrintMap(int location, String upDown, String correct) {
        OutputView outputView = new OutputView();
        addBridge(location, upDown, correct);
        outputView.printMap(upperBridgeMove, lowerBridgeMove);
    }

    private void addBridge(int location, String upDown, String correct) {
        if (upDown.equals("U")) {
            upperBridgeMove.add(location, correct);
            lowerBridgeMove.add(location, " ");
        } else if (upDown.equals("D")) {
            upperBridgeMove.add(location, " ");
            lowerBridgeMove.add(location, correct);
        }
    }

    private BridgeMove readMoving() {
        InputView inputView = new InputView();
        return new BridgeMove(inputView.readMoving());
    }

    private boolean checkMove(int index, String bridgeMoveUpDown) {
        String bridgeUpDown = bridge.get(index);
        return (bridgeMoveUpDown.equals(bridgeUpDown));
    }


}
