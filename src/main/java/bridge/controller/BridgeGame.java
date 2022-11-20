package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.User;
import bridge.domain.utils.BridgeState;
import bridge.domain.utils.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private GameState gameState;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        gameState = GameState.START;
    }

    public void run() {
        outputView.printStartGame();
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final User user = new User();
        final Bridge bridge = makeBridgeGame(bridgeMaker);
        while (gameState == GameState.START) {
            gameState = move(user, bridge);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameState move(User user, Bridge bridge) {
        String position = inputView.readMoving();
        boolean isAlive = bridge.isAlive(position, user.crossingBridgeNumber());
        user.addUserState(BridgeState.convertToBridgeState(position, isAlive));
        outputView.printMap(user);
        return isGameEnd(user, bridge, isAlive);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public Bridge makeBridgeGame(BridgeMaker bridgeMaker) {
        int bridgeSize;
        try {
            bridgeSize = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            makeBridgeGame(bridgeMaker);
        }
        return null;
    }

    public GameState isGameEnd(User user, Bridge bridge, boolean isAlive) {
        if (bridge.getBridgeSize() == user.crossingBridgeNumber() && isAlive)
            return GameState.END;
        if (!isAlive)
            return GameState.RETRY;
        return GameState.START;
    }

}
