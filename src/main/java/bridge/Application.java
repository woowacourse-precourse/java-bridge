package bridge;

import bridge.controller.NatureController;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.ErrorView;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.ViewFaçade;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        try {
            ViewFaçade viewFaçade = new ViewFaçade(new NatureController(integer -> {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return new BridgeGame(bridgeMaker.makeBridge(integer), new ArrayList<>());
            }));
            viewFaçade.start();
        } catch (IllegalArgumentException e) {
            new ErrorView().printErrorMessage(e.getMessage());
        }
    }
}
