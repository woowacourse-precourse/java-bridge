package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public void playGame() {
        List<List<String>> side = new ArrayList<>();
        while (true) {
            initBridgeStatus(side);
            List<List<String>> sideState = move(side);
            if (!checkFinalState(sideState)) break;
            clearMap(side);
        }
    }

    public boolean checkFinalState(List<List<String>> sideState) {
        if (sideState.get(0).contains("X") || sideState.get(1).contains("X")) {
            if (!retry(inputView.readGameCommand())) {
                outputView.printResult(sideState);
                return false;
            }
        }
        outputView.printResult(sideState);
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param side
     * @return
     */
    public List<List<String>> move(List<List<String>> side) {
        for (int location = 0; location < bridge.size(); location++) {
            String inputDirection = inputView.readMoving();
            if (correctDirection(location, inputDirection, side)) continue;
            if (notCorrectDirection(location, inputDirection, side)) break;
        }
        return side;
    }

    public List<List<String>> initBridgeStatus(List<List<String>> side) {
        side.add(new ArrayList<>());
        side.add(new ArrayList<>());
        return side;
    }

    public List<List<String>> clearMap(List<List<String>> side) {
        side.clear();
        return side;
    }

    private boolean notCorrectDirection(int location, String direction, List<List<String>> side) {
        if (!bridge.get(location).equals(direction)) {
            stepNotCorrectDirection(direction, side);
            outputView.printMap(side);
            return true;
        }
        return false;
    }

    private void stepNotCorrectDirection(String direction, List<List<String>> side) {
        if (direction.equals("U")) {
            step("X", " ", side);
        }
        if (direction.equals("D")) {
            step(" ", "X", side);
        }
    }

    private boolean correctDirection(int location, String direction, List<List<String>> side) {
        if (bridge.get(location).equals(direction)) {
            stepCorrectDirection(direction, side);
            outputView.printMap(side);
            return true;
        }
        return false;
    }

    private void stepCorrectDirection(String direction, List<List<String>> side) {
        if (direction.equals("U")) {
            step("O", " ", side);
        }
        if (direction.equals("D")) {
            step(" ", "O", side);
        }
    }

    private void step(String topSideStatus, String bottomSideStatus, List<List<String>> side) {
        side.get(0).add(topSideStatus);
        side.get(1).add(bottomSideStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @return
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            return true;
        }
        return false;
    }
}
