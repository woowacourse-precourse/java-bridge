package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeSetting;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        outputView.printStart();
        BridgeGame bridgeGame = new BridgeGame(make());
        String command = "";
        while (!bridgeGame.isEnd() && !command.equals(BridgeSetting.QUIT_COMMAND)) {
            move(bridgeGame);
            if (!bridgeGame.canStandOnCurrentBridge()) {
                command = retry(bridgeGame);
            }
        }
        outputView.printResult(bridgeGame);
    }

    private String retry(BridgeGame bridgeGame) {
        String command;

        command = inputView.readGameCommand();
        if (command.equals(BridgeSetting.RETRY_COMMAND)) {
            bridgeGame.retry();
        }
        return command;
    }

    public List<String> make() {
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }


    public void move(BridgeGame bridgeGame) {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame);
    }
}