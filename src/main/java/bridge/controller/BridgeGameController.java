package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    GameController gameController = new GameController();

    boolean isCorrect;
    boolean isStart;
    int count;

     public void start(){
         outputView.printStartGuide();
         Bridge bridge  = createBridge();
         isStart = true;
         count = 0;

         do{
             count++;
             isCorrect = gameController.start(bridge);
             isStart = updateIsStart(isCorrect);
         } while(isStart);

         outputView.printResult(count, isCorrect);
     }

    private boolean updateIsStart(boolean isCorrect) {
        if(! isCorrect){
            outputView.printInputRestartOptionGuide();
            String restartOption = inputView.readGameCommand();
            return getIsRestart(restartOption);
        }
        return false;
    }

    private boolean getIsRestart(String restartOption) {
        return restartOption.equals("R");
    }

    public Bridge createBridge(){
         outputView.printInputBridgeLengthGuide();
         int bridgeLength = inputView.readBridgeLength();

         return new Bridge(bridgeMaker.makeBridge(bridgeLength));
     }
}
