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
        retryUntilInitAvailableBridge();
        runUntilGameEnds();
    }

    private void retryUntilInitAvailableBridge() {
        try  {
            bridge = new Bridge(inputView.readBridgeSize(), new BridgeRandomNumberGenerator());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retryUntilInitAvailableBridge();
        }
    }

    private void runUntilGameEnds() {
        while (!bridge.gameWon()) {
            if (isGameFailEnded()) {
                return;
            }
        }
        outputView.printResult(bridge);
    }

    private boolean isGameFailEnded() {
        if (!retryUntilGetAvailableMove()) {
            if (!retryUntilGetAvailableRetryMsg()) {
                return true;
            }
        }
        return false;
    }

    private boolean retryUntilGetAvailableMove() {
        boolean moveSuccessful;
        try {
            moveSuccessful = move();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveSuccessful = retryUntilGetAvailableMove();
        }
        return moveSuccessful;
    }

    private boolean retryUntilGetAvailableRetryMsg() {
        boolean retry;
        try {
            retry = retry();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry = retryUntilGetAvailableRetryMsg();
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
