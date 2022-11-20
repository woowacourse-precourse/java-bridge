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
