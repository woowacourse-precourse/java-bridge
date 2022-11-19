package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.service.BridgeGameService;

public class BridgeGameController {
    private BridgeGameService bridgeGameService;
    private InputView inputView;
    private OutputView outputView;

    public BridgeGameController(BridgeGameService bridgeGameService, InputView inputView, OutputView outputView) {
        this.bridgeGameService = bridgeGameService;
        this.inputView = inputView;
        this.outputView = outputView;
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

    private String playMove() {
        outputView.printMove();
        String moving = inputView.readMoving();
        bridgeGameService.move(moving);
        outputView.printBridge(bridgeGameService.getUserBridge());
        return moving;
    }

    private boolean playFail(String moving) {
        if (bridgeGameService.fail(moving)) {
            outputView.printRetry();
            String retry = inputView.readGameCommand();

            if (playQuit(retry)) {
                return true;
            }
        }
        return false;
    }

    private boolean playQuit(String retry) {
        if (bridgeGameService.isQuit(retry)) {
            outputView.printFailResult(bridgeGameService);
            return true;
        }
        return false;
    }

    private void playEnd() {
        if (!bridgeGameService.play()) {
            outputView.printSuccessResult(bridgeGameService);
        }
    }
}
