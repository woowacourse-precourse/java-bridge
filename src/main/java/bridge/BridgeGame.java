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

    private boolean wantToRetry() {
        guideRetry();
        this.gameCommand = getGameCommand();
        return isRetryCommand();
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

    private void updatePath(String movingCommand) { this.path.add(movingCommand); }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메소드
     * <p>
     * 이동을 위해 필요한 메소드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move() {
        outputView.guideMovingCommandInput();
        String movingCommand = getMovingCommand();
        updatePath(movingCommand);
    }

    /**
     * 게임 결과를 출력하는 메소드
     */
    public void printResult() { outputView.printResult(this.path, this.bridge, this.numberOfTry); }

    private void printMap() { outputView.printMap(this.path, this.bridge); }

    private void guideRetry() { outputView.guideRetry(); }

    private String getMovingCommand() { return inputView.readMoving(); }

    private String getGameCommand() { return inputView.readGameCommand(); }

    /**
     * 플레이어가 다리 끝에 도달했는지 그 여부를 불린형으로 반환하는 메소드
     */
    private boolean isEnd() { return this.path.size() == this.bridge.size(); }

    /**
     * 종료 코드를 받았는지 확인하는 메소드
     */
    private boolean isRetryCommand() { return this.gameCommand.equals("R"); }

    /**
     * 사용자가 올바른 칸으로 이동했는지 여부를 불린으로 반환하는 메소드
     */
    private boolean isWrong() {
        int currentPartition = this.path.size() - 1;
        String currentMovingCommand = this.path.get(currentPartition);
        String currentBridgePartition = this.bridge.get(currentPartition);
        return !currentMovingCommand.equals(currentBridgePartition);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메소드
     * <p>
     * 재시작을 위해 필요한 메소드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        this.numberOfTry++;
        this.path.remove(this.path.size() - 1);
        move();
    }
}