package bridge.config;

import bridge.BridgeMaker;
import bridge.BridgeMakerInf;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.service.BridgeGameInf;
import bridge.util.InputContext;
import bridge.validation.InputValidationChain;
import bridge.validation.impl.BridgeLengthInputValidator;
import bridge.validation.impl.MoveSelectInputValidator;
import bridge.validation.impl.RestartOrQuitInputValidator;

public class BridgeConfig {

    public static BridgeController config() {
        BridgeMakerInf bridgeMaker = bridgeMakerDI();
        BridgeGameInf bridgeGame = new BridgeGame();
        InputValidationChain validationChain = validatorDI();
        InputContext inputContext = new InputContext();
        return new BridgeController(bridgeMaker, bridgeGame, validationChain, inputContext);
    }

    private static InputValidationChain validatorDI() {
        InputValidationChain bridgeLengthInputValidator = new BridgeLengthInputValidator();
        InputValidationChain moveSelectInputValidator = new MoveSelectInputValidator();
        InputValidationChain restartOrQuitInputValidator = new RestartOrQuitInputValidator();
        bridgeLengthInputValidator.setNextChain(moveSelectInputValidator);
        moveSelectInputValidator.setNextChain(restartOrQuitInputValidator);
        return bridgeLengthInputValidator;
    }

    private static BridgeMakerInf bridgeMakerDI() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
