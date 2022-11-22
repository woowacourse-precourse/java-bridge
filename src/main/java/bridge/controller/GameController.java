package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.BridgeGame;
import bridge.model.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public GameController(BridgeMaker bridgeMaker
            , InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStart();
        List<String> bridge = bridgeMaker
                .makeBridge(inputView.loopInput(inputView::readBridgeSize));

        BridgeGame game = new BridgeGame(bridge);
        start(game);
    }

    private void start(BridgeGame game) {
        while (game.getGameState().equals(GameState.NOT_FINISH)) {
            String move = inputView.loopInput(inputView::readMoving);
            game.move(move);
            outputView.printMap(game);

            retryOrQuit(game);
        }
    }

    private void retryOrQuit(BridgeGame game) {
        if (game.getGameState().equals(GameState.FINISH_FAIL)) {
            String command = inputView.loopInput(inputView::readGameCommand);
            game.retry(command);
        }
        if (!game.getGameState().equals(GameState.NOT_FINISH))
            outputView.printResult(game);
    }
}
