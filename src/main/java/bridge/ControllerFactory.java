package bridge;

import bridge.controller.Controller;
import bridge.controller.NatureController;
import bridge.domain.UserCharacters;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.mediator.ControllerMediator;
import bridge.service.BridgeGameService;

import java.util.ArrayList;

public class ControllerFactory {

    public static Controller makeController(ControllerMediator mediator) {
        return new NatureController(mediator, new BridgeGameService(
                new BridgeGame(new ArrayList<>()), new UserCharacters(new ArrayList<>()),new BridgeMaker(new BridgeRandomNumberGenerator())));
    }
}
