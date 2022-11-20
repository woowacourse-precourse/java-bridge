package bridge;

import bridge.controller.BridgeGame;
import bridge.dto.MapDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeProgram {

    private BridgeGame bridgeGame;

    private InputView inputView;

    private OutputView outputView;

    public BridgeProgram() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        outputView.printStart();
    }

    private void make() {
        while (true) {
            try {
                bridgeGame.make(inputView.readBridgeSize());
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private MapDto getMap() {
        while (true) {
            try {
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
