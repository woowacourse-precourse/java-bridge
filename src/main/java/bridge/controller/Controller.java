package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.message.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ExceptionController exceptionController = new ExceptionController();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final Bridge bridge;
    private boolean playing = true;

    public Controller() {
        System.out.println(Message.START_GAME);
        bridge = makeBridge();
    }

    private Bridge makeBridge() {
        System.out.println(Message.INPUT_SIZE);
        int bridgeSize = inputView.readBridgeSize();
        List<String> madeBridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(madeBridge);
    }

    public void run() {
        while (playing) {

        }
    }

}
