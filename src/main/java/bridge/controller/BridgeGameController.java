package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.service.BridgeGameService;

public class BridgeGameController {
    private BridgeGameService bridgeGameService;
    private InputView inputView;
    private OutputView outputView;
    private String retry;
    private String moving;

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

    private boolean playFail(String moving) {
        if (bridgeGameService.fail(moving)) {
            getGameCommand();
            if (playQuit()) {
                return true;
            }
        }
        return false;
    }

    private void getGameCommand() {
        while (true) {
            try {
                outputView.printRetry();
                retry = inputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }

    private boolean playQuit() {
        if (bridgeGameService.isQuit(retry)) {
            outputView.printResult(bridgeGameService, false);
            return true;
        }
        return false;
    }

    private String playMove() {
        getMoving();
        bridgeGameService.move(moving);
        outputView.printMap(bridgeGameService.getUserBridge());
        return moving;
    }

    private void getMoving() {
        while (true) {
            try {
                outputView.printMove();
                moving = inputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }

    private void playEnd() {
        if (!bridgeGameService.play()) {
            outputView.printResult(bridgeGameService, true);
        }
    }
}
