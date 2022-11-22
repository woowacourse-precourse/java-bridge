package bridge;

import bridge.enums.Inputs;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Bridge bridge;

    public void run() {
        outputView.printInitMessage();
        assertAvailableBridge();
        runUntilGameEnds();
    }

    private void assertAvailableBridge() {
        try  {
            bridge = new Bridge(inputView.readBridgeSize(), new BridgeRandomNumberGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertAvailableBridge();
        }
    }

    private void runUntilGameEnds() {
        while (!bridge.gameWon()) {
            if (isGameFailed()) {
                return;
            }
        }
        outputView.printResult(bridge);
    }

    private boolean isGameFailed() {
        if (!assertAvailableMove()) {
            if (!assertRetry()) {
                return true;
            }
        }
        return false;
    }

    private boolean assertAvailableMove() {
        boolean moveSuccessful;
        try {
            moveSuccessful = move();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveSuccessful = assertAvailableMove();
        }
        return moveSuccessful;
    }

    private boolean assertRetry() {
        boolean retry;
        try {
            retry = retry();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry = assertRetry();
        }
        return retry;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        Inputs input = inputView.readMoving();
        boolean moveSuccess = bridge.moveNext(input);
        outputView.printMap(bridge);
        return moveSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String retry = inputView.readGameCommand();
        if (isRetry(retry)) {
            bridge.resetMoveStatus();
            return true;
        }
        outputView.printResult(bridge);
        return false;
    }

    private boolean isRetry(String retry) {
        return retry.equals(Inputs.RETRY.getMessage());
    }
}
