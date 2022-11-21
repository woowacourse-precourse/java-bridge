package bridge.view;

import bridge.mediator.Mediator;
import bridge.dto.BridgeStatusDto;

import java.util.HashMap;

public class ViewFaçade {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private Mediator mediator;

    public ViewFaçade(Mediator mediator) {
        this.mediator = mediator;
    }

    public void start() {
        outputView.printStartMessage();
        outputView.printInputBridgeSizeMessage();
        mediator.generateBridge(inputView.readBridgeSize());
    }

    public Runnable moveBride() {
        outputView.printMoveMessage();
        HashMap<String, String> map = new HashMap<>();
        Runnable runnable = mediator.moveBridge(inputView.readMoving(), map);
        outputView.printMap(map.get("bridge"));
        return runnable;
    }

    public void reply() {
        outputView.printReplyMessage();
        mediator.replay(inputView.readGameCommand());
    }

    public void end(BridgeStatusDto bridgeStatusDto) {
        outputView.printResult(bridgeStatusDto.getBridge(), bridgeStatusDto.getSuccessOrFailure(), bridgeStatusDto.getCount());
    }

}
