package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeResult;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.constant.BridgeConstant.BRIDGE_QUIT_COMMAND;
import static bridge.constant.BridgeConstant.BRIDGE_RETRY_COMMAND;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeResult bridgeResult;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;
    private User user;
    private int tryCount;
    public void runGame() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        move();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        bridgeResult = new BridgeResult();
        user = new User(bridge, bridgeResult);
        this.tryCount ++;
        while (checkUserMove()) {
            user.move(inputView.readMoving());
            outputView.printMap(bridgeResult);
        }
        judge();
    }

    private boolean checkUserMove() {
        if (user.isFinishedMove() || !user.getMoveStatus()) {
            return false;
        }
        return true;
    }

    private void judge() {
        if (user.isFinishedMove()) {
            endGame(true, tryCount);
        }
        if (!user.getMoveStatus()) {
            retry();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(BRIDGE_RETRY_COMMAND)) {
            move();
        }
        if (gameCommand.equals(BRIDGE_QUIT_COMMAND)) {
            endGame(false, tryCount);
        }
    }

    public void endGame(boolean gameResult, int tryCount) {
        outputView.printResult(bridgeResult,gameResult,tryCount);
    }
}
