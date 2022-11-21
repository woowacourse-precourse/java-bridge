package bridge.view;

import bridge.dto.BridgeStatusDto;
import bridge.controller.Controller;

import java.util.HashMap;

public class ViewFaçade {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private Controller controller;

    public ViewFaçade(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        outputView.printStartMessage();
        outputView.printInputBridgeSizeMessage();
        Runnable runnable = controller.generateBridge(this, inputView.readBridgeSize());
        runnable.run();
    }

    public void moveBride() {
        outputView.printMoveMessage();
        HashMap<String, String> map = new HashMap<>();
        Runnable runnable = controller.moveBridge(inputView.readMoving(), map);
        outputView.printMap(map.get("bridge"));
        runnable.run();
    }

    public void reply() {
        outputView.printReplyMessage();
        Runnable replay = controller.replay(inputView.readGameCommand());
        replay.run();
    }

    public void end(BridgeStatusDto bridgeStatusDto) {
        outputView.printResult(bridgeStatusDto.getBridge(), bridgeStatusDto.getSuccessOrFailure(), bridgeStatusDto.getCount());
    }
}
