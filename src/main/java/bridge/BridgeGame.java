package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridge;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameController bridgeGameController;
    private final GameStatus gameStatus;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGameController = new BridgeGameController(new BridgeGameService());
        this.gameStatus = new GameStatus();
    }

    public void play() {
        outputView.printStart();
        outputView.printBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = bridgeGameController.createBridge(bridgeSize);
        while (!gameStatus.getEnd()) {
            System.out.println(bridge.getBridge());
            crossBridge(bridge);
        }
        outputView.printResult(gameStatus);
    }

    private void crossBridge(Bridge bridge) {
        // TODO: 함수길이 초과 리팩토링 요망
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            String moving = move();
            outputView.printMap(bridge, i, moving);
            if (!bridge.canMove(i, moving)) {
                gameStatus.addGameCount();
                retry();
                return;
            }
        }
        gameStatus.setEnd(true);
        gameStatus.setGameClear(true);
    }

    public String move() {
        outputView.printMoving();
        String moving = inputView.readMoving();
        return moving;
    }

    public void retry() {
        outputView.printRetry();
        String answer = inputView.readGameCommand();
        quit(answer);
    }

    private void quit(String answer) {
        // TODO: Enum으로 리팩토링
        if (answer.equals("Q")) {
            gameStatus.setEnd(true);
        }
    }
}
