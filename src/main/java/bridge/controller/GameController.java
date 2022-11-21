package bridge.controller;

import bridge.type.GameOptionType;
import bridge.type.ResultType;
import bridge.view.OutputView;


public class GameController extends AbstractGameController{

    public GameController() {
        bridgeInfo = bridgeMaker.makeBridge(inputView.readBridgeSize());
        tryCnt = 1;
    }


    public boolean run() {
        if (!passThisRound()) {
            return askOption();
        }
        if (bridgeGame.isSucceed(bridgeInfo)) {
            end(ResultType.SUCCESS);
            return false;
        }
        return true;
    }

    public boolean askOption() {
        if (inputView.readGameCommand() == GameOptionType.Q) {
            end(ResultType.FAIL);
            return false;
        }
        addTryCnt();
        return bridgeGame.retry();
    }


    public void end(ResultType resultType) {
        OutputView.printGameEndMsg();
        bridgeGame.drawFinal(resultType, tryCnt);
    }


    public boolean passThisRound() {
        System.out.println(bridgeInfo);
        if (!bridgeGame.move(bridgeInfo, inputView.readMoving())) {
            return false;
        }
        return true;
    }

    public void addTryCnt() {
        tryCnt++;
    }

}
