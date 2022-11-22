package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.domain.Moving;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private Moving moving;
    private Result result;
    private Bridge bridge;

    public BridgeGameController() {
        this.moving = new Moving();
        this.result = new Result();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start() {
        outputView.printStartMessage();
        int size = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        bridgeGame = new BridgeGame(bridge,moving,result);
        run();
        makeTotalResult();
    }

    public void run() {
        result.plusTryCount();
        while(result.isKeeping()&&moving.isRight() && moving.getCount()<bridge.getBridge().size()){
            String inputMoving = inputView.readMoving();
            bridgeGame.move(bridge,inputMoving);
            combineUpDown();
        }
        if(!moving.isRight())
            checkRetry();
    }

    public void checkRetry(){
        String restart = inputView.readGameCommand();
        if(bridgeGame.retry(restart)) {
            moving.resetCount();
            result.resetAllResult();
            moving.resetUpDown();
            run();
        }
    }
    public void combineUpDown(){
        result.resetAllResult();
        result.combineResult(moving.getUp(),moving.getDown());
        outputView.printMap(result.getAllResults());
    }

    public void makeTotalResult(){
        bridgeGame.judgeResult();
        outputView.printResult(result.getAllResults(),result.getResultType().getName(),result.getTryCount());
    }
}
