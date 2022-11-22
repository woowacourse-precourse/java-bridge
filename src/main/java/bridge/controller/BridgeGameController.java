package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.bridge.BridgeNumberGenerator;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker;
    Bridge bridge;
    BridgeGame bridgeGame;
    boolean isSuccess, restart;


    public BridgeGameController(BridgeNumberGenerator bridgeNumberGenerator){
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

     public void start(){
         outputView.printStartGuide();
         bridge  = createBridge();

         firstRoundStart();

         while(restart){
             restartRoundStart();
         }

         outputView.printResult(bridgeGame.getGameRoundCount(), isSuccess);
     }

    private Bridge createBridge(){
        outputView.printInputBridgeLengthGuide();
        int bridgeLength = inputView.readBridgeLength();

        return new Bridge(bridgeMaker.makeBridge(bridgeLength));
    }

    private void firstRoundStart() {
        bridgeGame = new BridgeGame(bridge);
        newRoundStart();
    }

    private void newRoundStart() {
        isSuccess = getRoundResultAndPrintMap();
        restart = getIsNeedRestart(isSuccess);
    }

    private boolean getRoundResultAndPrintMap() {
        boolean isSuccessMove;

        do{
            outputView.printInputMovingGuide();
            String moving = inputView.readMoving();
            isSuccessMove = bridgeGame.move(moving);

            outputView.printMap(bridgeGame.getGameResult());
        } while(isSuccessMove && bridgeGame.isUserCanMove());

        return isSuccessMove;
    }

    private boolean getIsNeedRestart(boolean isSuccess) {
        if(isSuccess){
            return false;
        }
        outputView.printInputRestartOptionGuide();
        String restartOption = inputView.readRestartOption();
        return Validator.isNeedRestart(restartOption);
    }

    private void restartRoundStart() {
        bridgeGame.retry();
        newRoundStart();
    }
}
