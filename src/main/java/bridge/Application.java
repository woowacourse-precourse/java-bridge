package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameRepository;
import bridge.domain.vo.BridgeSize;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import bridge.view.InputView;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;

//TODO 객체 관계 그래프 작성
public class Application {

    private static final InputView inputView = new InputViewProxy();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        inputView.printStartMessage();
        BridgeGame bridgeGame = createBridgeGame(inputView.readBridgeSize());
        GameResult gameResult = playBridgeGame(bridgeGame);
        outputView.printResult(gameResult);
    }

    private static BridgeGame createBridgeGame(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameRepository bridgeGameRepository = new BridgeGameRepository();
        return BridgeGame.of(bridgeGameRepository, bridgeMaker, bridgeSize);
    }

    private static GameResult playBridgeGame(BridgeGame bridgeGame) {
        MoveResult moveResult = moveToSelectedBlock(bridgeGame);
        if (!moveResult.isSuccess()) {
            return selectWhetherToRetry(bridgeGame);
        }

        if (!bridgeGame.isGameClear()) {
            return playBridgeGame(bridgeGame);
        }
        return bridgeGame.closeGame();
    }

    private static MoveResult moveToSelectedBlock(BridgeGame bridgeGame) {
        MoveResult moveResult = bridgeGame.move(inputView.readMoving());
        outputView.printMap(moveResult);
        return moveResult;
    }

    private static GameResult selectWhetherToRetry(BridgeGame bridgeGame) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            outputView.clearMap();
            return playBridgeGame(bridgeGame);
        }
        return bridgeGame.closeGame();
    }
}
