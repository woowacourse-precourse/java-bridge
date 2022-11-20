package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private List<List<String>> side = new ArrayList<>();

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while (true) {
            initBridgeStatus();
            isValidDirection();
            clearMap(side);
        }
    }

    private void isValidDirection() {
        for (int location = 0; location < bridge.size(); location++) {
            String inputDirection = inputView.readMoving();
            if (correctDirection(location, inputDirection)) continue;
            if (notCorrectDirection(location, inputDirection)) break;
        }
    }

    private void initBridgeStatus() {
        side.add(new ArrayList<>());
        side.add(new ArrayList<>());
    }

    private void clearMap(List<List<String>> side) {
        side.clear();
    }

    private boolean notCorrectDirection(int location, String direction) {
        if (!bridge.get(location).equals(direction)) {
            stepNotCorrectDirection(direction);
            outputView.printMap(side);
            return true;
        }
        return false;
    }

    private void stepNotCorrectDirection(String direction) {
        if (direction.equals("U")) {
            step("X", " ");
        }
        if (direction.equals("D")) {
            step(" ", "X");
        }
    }

    private boolean correctDirection(int location, String direction) {
        if (bridge.get(location).equals(direction)) {
            stepCorrectDirection(direction);
            outputView.printMap(side);
            return true;
        }
        return false;
    }

    private void stepCorrectDirection(String direction) {
        if (direction.equals("U")) {
            step("O", " ");
        }
        if (direction.equals("D")) {
            step(" ", "O");
        }
    }

    private void step(String topSideStatus, String bottomSideStatus) {
        side.get(0).add(topSideStatus);
        side.get(1).add(bottomSideStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
