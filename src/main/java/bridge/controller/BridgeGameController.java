package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGameService bridgeGameService;
    private InputController inputController;
    private OutputView outputView;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
        inputController = new InputController();
        outputView = new OutputView();
    }

    public void makeBridge() {
        outputView.printStart();
        bridgeGameService.makeBridge(inputController.suggestBridgeSize());
    }

    public void playGame() {
        while (bridgeGameService.play()) {
            String moving = playMove();
            if (playFail(moving)) {
                break;
            }
            bridgeGameService.increaseStep();
        }
        playEnd();
    }

    private boolean playFail(String moving) {
        if (bridgeGameService.fail(moving)) {
            if (playQuit()) {
                return true;
            }
        }
        return false;
    }

    private boolean playQuit() {
        String retry = inputController.suggestGameCommand();
        if (bridgeGameService.isQuit(retry)) {
            outputView.printResult(bridgeGameService, false);
            return true;
        }
        return false;
    }

    private String playMove() {
        String moving = inputController.suggestMoving();
        bridgeGameService.move(moving);
        outputView.printMap(bridgeGameService.getUserBridge());
        return moving;
    }

    private void playEnd() {
        if (!bridgeGameService.play()) {
            outputView.printResult(bridgeGameService, true);
        }
    }
}
