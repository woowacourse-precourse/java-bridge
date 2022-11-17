package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeSize;

import java.util.List;

import static bridge.view.InputView.*;

public class BridgeController {

    public BridgeController(){
    }

    public void start() {
        BridgeSize bridgeSize = readBridgeSize();
    }
}
