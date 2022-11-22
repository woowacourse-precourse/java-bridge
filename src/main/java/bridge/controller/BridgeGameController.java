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
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

     public void start(){
         outputView.printStartGuide();
         Bridge bridge  = createBridge();

     }

     public Bridge createBridge(){
         outputView.printInputBridgeLengthGuide();
         int bridgeLength = inputView.readBridgeLength();

         return new Bridge(bridgeMaker.makeBridge(bridgeLength));
     }
}
