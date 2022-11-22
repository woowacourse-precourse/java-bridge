package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridge;
import bridge.domain.BridgePassed;
import bridge.enumeration.GameCommand;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameController bridgeGameController;
    private final GameStatus gameStatus;
    private BridgePassed bridgePassed;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGameController = new BridgeGameController(new BridgeGameService());
        this.gameStatus = new GameStatus();
    }

    public void play() {
        Bridge bridge = makeBridge();
        while (!gameStatus.getEnd()) {
            crossBridge(bridge);
        }
        outputView.printFinalMap(bridgePassed);
        outputView.printResult(gameStatus);
    }

    private Bridge makeBridge() {
        outputView.printStart();
        outputView.printBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeGameController.createBridge(bridgeSize);
    }

    private void crossBridge(Bridge bridge) {
        gameStatus.addGameCount();
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            bridgePassed = move(bridge, i);
            outputView.printMap(bridgePassed);
            if (!bridgePassed.canMove()) {
                retry();
                return;
            }
        }
        gameStatus.setEnd(true);
        gameStatus.setGameClear(true);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgePassed move(Bridge bridge, int index) {
        outputView.printMoving();
        String moving = inputView.readMoving();
        return bridgeGameController.showBridgePassed(bridge, index, moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        outputView.printRetry();
        String answer = inputView.readGameCommand();
        quit(answer);
    }

    private void quit(String answer) {
        if (answer.equals(GameCommand.QUIT.getCommand())) {
            gameStatus.setEnd(true);
        }
    }
}
