package bridge;

import bridge.enums.RetryCommand;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int currentIndex = 0;
    private int bridgeSize;
    private List<String> bridge;
    private int tryCount = 1;
    private OutputView outputView = new OutputView();
//    InputView inputView = new InputView();

    public BridgeGame(int bridgeSize, List<String> bridge) {
        this.bridgeSize = bridgeSize;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (!this.bridge.get(currentIndex).equals(moving)) {
            outputView.printWrongMap(this, this.currentIndex, moving);
            return true;
        }

        currentIndex += 1;
        outputView.printMap(this, this.currentIndex);

        return false;
    }

    public boolean isEndGame() {
        if (this.currentIndex == this.bridgeSize) {
            printSuccessEnd(this.tryCount);
            return true;
        }

        return false;
    }

    private void printSuccessEnd(int tryCount) {
        System.out.println();
        System.out.println("최종 게임 결과");
        outputView.printResult(this, this.currentIndex);
        System.out.println("게임 성공 여부: 성공");
        System.out.println(String.format("총 시도한 횟수: %d", tryCount));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.currentIndex = 0;
        this.tryCount += 1;
    }

    public boolean isRetry(String command) {
        if (command.equals(RetryCommand.RETRY.getCommand())) {
            retry();
            return true;
        }

        return false;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public OutputView getOutputView() {
        return this.outputView;
    }
}
