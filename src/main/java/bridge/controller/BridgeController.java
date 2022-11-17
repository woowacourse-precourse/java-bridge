package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private InputView inputView;

    private OutputView outputView;

    private BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        printStartMessage();
        makeBridge();




        }
    }

    private String movePlayer() {
    }

    private void makeBridge() {
        while (true) {
            String input = inputView.readBridgeSize();
            try {
                bridgeGame.makeBridge(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            break;
        }
    }

    private void printStartMessage() {
        outputView.printGreetingMessage();
    }
}
