package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.UserState;
import bridge.domain.enums.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlay {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void bridgeGameStart() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        UserState userState = new UserState();
        bridgeGameTry(bridge, userState);
        outputView.printResult(userState, bridgeSize);
    }

    private void bridgeGameTry(Bridge bridge, UserState userState) {
        while (!userState.isQuit()) {
            bridgeGame.retry(userState);
            bridgeCross(bridge, userState);
            if (userState.isSuccessOrFail(bridge.getSize())) {
                return;
            }
            userState.quitChange(inputView.readGameCommand().equals(Command.QUIT.getCommand()));
        }
    }

    private void bridgeCross(Bridge bridge, UserState userState) {
        while (userState.getStep() < bridge.getSize()) {
            String userChoice = inputView.readMoving();
            boolean isSafe = bridge.isSafe(userState.getStep(), userChoice);
            bridgeGame.move(userState, isSafe, userChoice);
            outputView.printMap(userState.toString());
            if (!isSafe) {
                return;
            }
        }
    }
}
