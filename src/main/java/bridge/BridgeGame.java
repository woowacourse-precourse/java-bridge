package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final Bridges gameBridges;
    private int gameTryCount;

    public BridgeGame(List<String> bridges) {
        this.gameBridges = new Bridges(bridges);
        this.gameTryCount = 0;
    }

    public void play() {
        ++gameTryCount;
        while (!this.isCleared()) {
            boolean isMoveSuccess = move(inputView.readMoving());
            outputView.printMap(gameBridges);
            if (!isMoveSuccess) {
                return;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (this.isCleared()) {
            return false;
        }
        return gameBridges.tryPass(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameBridges.init();
        play();
    }

    public boolean isCleared() {
        return gameBridges.isAllPassed();
    }

    public int getTryCount() {
        return this.gameTryCount;
    }

    public Bridges getGameBridges() {
        return this.gameBridges;
    }
}
