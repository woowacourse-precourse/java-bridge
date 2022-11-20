package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.service.BridgeMakerService;
import bridge.type.GameStatusType;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final Bridge bridge;
    private final List<String> bridgeInfo;
    private final BridgeGame bridgeGame;
    private int gameCount;

    public BridgeGameController() {
        this.bridge = createBridge();
        this.bridgeInfo = bridge.getBridge();
        this.bridgeGame = new BridgeGame(bridgeInfo);
        this.gameCount = 0;
    }

    public void start() {
        gameCount++;
        while (bridgeGame.getGameStatus().isPlaying()) {
            bridgeGame.move();
            OutputView.printMap(bridgeGame.printPlayingMap());
        }
        if (bridgeGame.getGameStatus() == GameStatusType.FAIL && askRestart()) {
            bridgeGame.retry();
            start();
        }
        if (bridgeGame.getGameStatus() == GameStatusType.FAIL && !askRestart()) {
            OutputView.printResult(bridgeGame.printPlayingMap(), GameStatusType.FAIL, gameCount);
        }
        if (bridgeGame.getGameStatus() == GameStatusType.END) {
            OutputView.printResult(bridgeGame.printPlayingMap(), GameStatusType.END, gameCount);
        }
    }

    private boolean askRestart() {
        String status = InputView.readGameCommand();
        return status.equals("R");
    }

    private Bridge createBridge() {
        while (true) {
            try {
                int size = InputView.readBridgeSize();
                return BridgeMakerService.createBridge(size);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
