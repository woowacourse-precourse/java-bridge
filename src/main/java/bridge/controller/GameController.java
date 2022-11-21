package bridge.controller;

import bridge.service.GameServiceImpl;
import bridge.service.impl.GameService;
import bridge.type.ResultType;
import bridge.view.OutputView;


public class GameController extends AbstractGameController{
    GameService gameService = new GameServiceImpl();

    public GameController() {
        bridgeInfo = bridgeMaker.makeBridge(inputView.readBridgeSize());
        tryCnt = 1;
    }


    public boolean run() {
        if (gameService.passThisRound(bridgeInfo)) {
            return true;
        }
        if (gameService.getEndType() != ResultType.SUCCESS) {
            tryCnt++;
            retryGame();
        }
        return endGame(gameService.getEndType());
    }

    public boolean retryGame() {
        return gameService.askOption();
    }


    public boolean endGame(ResultType resultType) {
        OutputView.printGameEndMsg();
        bridgeGame.drawFinalResult(resultType, tryCnt);
        return false;
    }

}
