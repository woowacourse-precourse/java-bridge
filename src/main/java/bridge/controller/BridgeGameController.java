package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;
import bridge.domain.factory.BridgeFactory;
import bridge.domain.game.BridgeGame;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.command.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void runGameMain() {
        try {
            runBridgeGame();
        } catch (RuntimeException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void runBridgeGame() {
        outputView.printStart();
        int size = inputView.readBridgeSize();

        BridgeFactory bridgeFactory = new BridgeFactory();
        Bridge bridge = bridgeFactory.createBridge(size);
        Pedestrian pedestrian = new Pedestrian();
        BridgeGame bridgeGame = BridgeGame.from(bridge);

        while(!bridgeGame.isSuccess(pedestrian)) {
            Direction direction = new Direction(inputView.readMoving());
            bridgeGame.move(pedestrian, direction);

            outputView.printMap(pedestrian);

            if (pedestrian.hasIncorrectDirection()) {
                Command command = new Command(inputView.readGameCommand());
                if (command.isToEndGame()) {
                    break;
                }
                bridgeGame.retry(pedestrian);
                bridgeGame.countRound();
            }
        }
        outputView.printResultTitle();
        outputView.printMap(pedestrian);
        outputView.printResult(bridgeGame.isSuccess(pedestrian), bridgeGame.countRound());
    }
}
