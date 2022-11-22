package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.GameEndChecker;
import bridge.domain.Player;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameController bridgeGameController;
    private final GameEndChecker gameEndChecker;
    private final Player player;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGameController = new BridgeGameController(new BridgeGameService());
        this.gameEndChecker = new GameEndChecker();
        this.player = new Player();
    }

    public void play() {
        outputView.printStart();
        outputView.printBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = bridgeGameController.createBridge(bridgeSize);
        while (!gameEndChecker.getEnd()) {
            System.out.println(bridge.getBridge());
            crossBridge(bridge);
        }
        outputView.printResult(player);
    }

    private void crossBridge(Bridge bridge) {
        // TODO: 함수길이 초과 리팩토링 요망
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            String moving = move(bridge, i);
            outputView.printMap(bridge, i, moving);
            if (!bridge.canMove(i, moving)) {
                player.addGameCount();
                retry();
                return;
            }
        }
        gameEndChecker.setEnd(true);
        player.setGameClear(true);
    }

    public String move(Bridge bridge, int index) {
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
            gameEndChecker.setEnd(true);
        }
    }
}
