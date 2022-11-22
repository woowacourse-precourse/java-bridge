package bridge;

import bridge.controller.Controller;
import bridge.controller.NatureController;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.mediator.ControllerMediator;

import java.util.ArrayList;

public class ControllerFactory {

    public static Controller makeController(ControllerMediator mediator){
        return new NatureController((ControllerFactory::createBridgeGame),mediator);
    }

    private static BridgeGame createBridgeGame(Integer integer) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new BridgeGame(bridgeMaker.makeBridge(integer), new ArrayList<>());
    }
}
