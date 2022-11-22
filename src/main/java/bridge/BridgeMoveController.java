package bridge;

import static bridge.constant.Commands.DOWN_COMMAND;
import static bridge.constant.Commands.UP_COMMAND;

import bridge.domain.BridgeMove;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BridgeMoveController {

    public static final String CAN_CROSS_BRIDGE = "O";
    public static final String CANNOT_CROSS_BRIDGE = "X";
    public static final String EMPTY_SPACE = " ";

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
        String correct = CAN_CROSS_BRIDGE;
        while (location < bridge.size() && correct.equals(CAN_CROSS_BRIDGE)) {
            correct = checkCorrectAndBuildBridge(location++);
        }
    }

    private String checkCorrectAndBuildBridge(int location) {
        String upDown = readMoving().getMove();
        String correct = CANNOT_CROSS_BRIDGE;
        if (checkMove(location, upDown)) {
            correct = CAN_CROSS_BRIDGE;
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
        if (upDown.equals(UP_COMMAND)) {
            upperBridgeMove.add(location, correct);
            lowerBridgeMove.add(location, EMPTY_SPACE);
        } else if (upDown.equals(DOWN_COMMAND)) {
            upperBridgeMove.add(location, EMPTY_SPACE);
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
