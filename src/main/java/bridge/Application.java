package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameRepository;
import bridge.domain.generator.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import bridge.view.InputView;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;

//TODO 객체 관계 그래프 작성
public class Application {

    private static final BridgeGame bridgeGame = new BridgeGame(new BridgeGameRepository());
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final InputView inputView = new InputViewProxy();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        inputView.printStartMessage();
        Bridge bridge = bridgeGame.getBridge(bridgeMaker, inputView.readBridgeSize());
        GameResult gameResult = playBridgeGame(bridge);
        outputView.printResult(gameResult);
    }

    private static GameResult playBridgeGame(Bridge bridge) {
        MoveResult moveResult = moveToSelectedBlock(bridge);
        if (!moveResult.isSuccess()) {
            return selectWhetherToRetry(bridge);
        }

        if (!bridgeGame.isGameClear()) {
            return playBridgeGame(bridge);
        }
        return bridgeGame.closeGame();
    }

    private static MoveResult moveToSelectedBlock(Bridge bridge) {
        MoveResult moveResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(moveResult);
        return moveResult;
    }

    private static GameResult selectWhetherToRetry(Bridge bridge) {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            outputView.clearMap();
            return playBridgeGame(bridge);
        }
        return bridgeGame.closeGame();
    }
}
