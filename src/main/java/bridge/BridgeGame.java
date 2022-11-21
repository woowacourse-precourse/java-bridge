package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();

    private final List<String> bridge, path;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.path = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메소드
     */
    public void move() {
        String movingCommand = getMovingCommand();
        updatePath(movingCommand);
    }

    public void printMap() { outputView.printMap(this.path, this.bridge); }

    public boolean isMoveWrong() {
        int currentPartition = this.path.size() - 1;
        String currentMovingCommand = this.path.get(currentPartition);
        String currentBridgePartition = this.bridge.get(currentPartition);
        return !currentMovingCommand.equals(currentBridgePartition);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메소드
     */
    public void retry() {
        this.path.remove(this.path.size() - 1);
        move();
    }

    /**
     * 게임 결과를 출력하는 메소드
     */
    public void printResult(int numberOfTry) { outputView.printResult(this.path, this.bridge, numberOfTry); }

    public boolean isEnd() { return this.path.equals(this.bridge); }

    private String getMovingCommand() { return inputView.readMovingCommand(); }

    private void updatePath(String movingCommand) { this.path.add(movingCommand); }
}
