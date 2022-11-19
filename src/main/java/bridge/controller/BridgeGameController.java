package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.utils.InputHandler;
import java.util.List;

public class BridgeGameController {

    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";

    private final InputHandler inputHandler = new InputHandler();

    public void runGame(){
        int size = inputHandler.getBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        new BridgeGame().start(size, bridge);
    }

    public String isSuccess(boolean isAnswer) {
        if (isAnswer) {
            return SUCCESS;
        }
        return FAIL;
    }
}
