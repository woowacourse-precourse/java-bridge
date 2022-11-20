package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.OutputView;
import bridge.view.InputView;
import bridge.domain.Validation;

import java.util.List;

public class BridgeGameController {
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeGame bridgeGame;
    private boolean moving = true;

    public void start(){
        OutputView.startMessage();

        while (true){
            try {
                bridgeGame = new BridgeGame(generateBridge());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> generateBridge(){
        int bridgeSize = InputView.inputBridgeSize();
        Validation.validateRange(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
