package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.GameServiceImpl;
import bridge.service.itf.GameService;
import bridge.type.ResultType;
import bridge.view.OutputView;


public class GameController extends AbstractGameController{
    GameService gameService = new GameServiceImpl();

    public GameController() {
        bridgeInfo = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }


    public boolean run() {
        if (gameService.passThisRound(bridgeInfo)) {
            return true;
        }
        endGame(gameService.getEndType());
        return false;
    }


    public boolean endGame(ResultType resultType) {
        OutputView.printGameEndMsg();
        bridgeGame.drawFinalResult(resultType, BridgeGame.getTryCnt());
        return false;
    }

}
