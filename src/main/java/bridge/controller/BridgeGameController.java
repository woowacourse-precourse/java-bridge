package bridge.controller;

import bridge.view.OutputView;
import bridge.service.BridgeGameService;

public class BridgeGameController {
    private BridgeGameService bridgeGameService;
    private OutputView outputView;
    private InputController inputController;

    public BridgeGameController(BridgeGameService bridgeGameService, OutputView outputView,
                                InputController inputController) {
        this.bridgeGameService = bridgeGameService;
        this.outputView = outputView;
        this.inputController = inputController;
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
