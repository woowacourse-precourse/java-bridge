package bridge;

가import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {


    private static final BridgeMaker bridgeMaker = new BridgeMaker(null);
    private static final String BLANK = " ";
    public static void main(String[] args) {

        BridgeController bridgeController = new BridgeController();
        bridgeController.run();
    }
}
