package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();

    private List<String> bridge, path;
    private String gameCommand;
    private int numberOfTry;

    /**
     * 생성자, 게임을 초기화 함
     */
    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.path = new ArrayList<>();
        this.numberOfTry = 1;
        this.gameCommand = "R";
    }

    /**
     * 게임을 실행하는 메소드
     */
    public void run() {
        while (!isEnd()) {
            move();
            printMap();
            while (isWrong() && wantToRetry()) {
                retry();
                printMap();
            }
            if (!isRetryCommand()) return;
        }
    }

    /**
     * 게임 결과를 출력하는 메소드
     */
    public void printResult() { outputView.printResult(this.path, this.bridge, this.numberOfTry); }

    private boolean isEnd() { return this.path.equals(this.bridge); }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메소드
     */
    private void move() {
        outputView.guideMovingCommandInput();
        String movingCommand = getMovingCommand();
        updatePath(movingCommand);
    }

    private String getMovingCommand() { return inputView.readMoving(); }
    private void updatePath(String movingCommand) { this.path.add(movingCommand); }

    private void printMap() { outputView.printMap(this.path, this.bridge); }

    private boolean isWrong() {
        int currentPartition = this.path.size() - 1;
        String currentMovingCommand = this.path.get(currentPartition);
        String currentBridgePartition = this.bridge.get(currentPartition);
        return !currentMovingCommand.equals(currentBridgePartition);
    }

    private boolean wantToRetry() {
        guideRetry();
        this.gameCommand = getGameCommand();
        return isRetryCommand();
    }

    private void guideRetry() { outputView.guideRetry(); }
    private String getGameCommand() { return inputView.readGameCommand(); }
    private boolean isRetryCommand() { return this.gameCommand.equals("R"); }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메소드
     */
    private void retry() {
        this.numberOfTry++;
        this.path.remove(this.path.size() - 1);
        move();
    }
}
