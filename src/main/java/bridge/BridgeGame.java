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
            // TODO: 로그 지우기
            System.out.println(bridge.getBridge());
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

    public BridgePassed move(Bridge bridge, int index) {
        outputView.printMoving();
        String moving = inputView.readMoving();
        return bridgeGameController.showBridgePassed(bridge, index, moving);
    }

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
