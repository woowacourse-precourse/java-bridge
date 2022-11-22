package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameRepository;
import bridge.domain.vo.BridgeSize;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.printStartMessage();
        BridgeGame bridgeGame = createBridgeGame(inputView.readBridgeSize());
        GameResult gameResult = playBridgeGame(bridgeGame);
        outputView.printResult(gameResult);
    }

    private BridgeGame createBridgeGame(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();
        return BridgeGame.of(bridgeGameRepository, bridgeMaker, bridgeSize);
    }

    private  GameResult playBridgeGame(BridgeGame bridgeGame) {
        MoveResult moveResult = moveToSelectedBlock(bridgeGame);
        if (!moveResult.isSuccess()) {
            return selectWhetherToRetry(bridgeGame);
        }

        if (!bridgeGame.isGameClear()) {
            return playBridgeGame(bridgeGame);
        }
        return bridgeGame.closeGame();
    }

    private MoveResult moveToSelectedBlock(BridgeGame bridgeGame) {
        MoveResult moveResult = bridgeGame.move(inputView.readMoving());
        outputView.printMap(moveResult);
        return moveResult;
    }

    private GameResult selectWhetherToRetry(BridgeGame bridgeGame) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            outputView.clearMap();
            return playBridgeGame(bridgeGame);
        }
        return bridgeGame.closeGame();
    }
}
