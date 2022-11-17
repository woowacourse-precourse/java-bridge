package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;

public class InputController {

    public static Bridge inputBridgeSize(){
        return new Bridge(InputView.readBridgeSize());
    }

}
