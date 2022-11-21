package bridge.view;

import bridge.dto.BridgeStatusDto;
import bridge.controller.Controller;

import java.util.HashMap;

public class ViewFaçade {

    private InputView inputView;
    private OutputView outputView;

    private Controller controller;

    public ViewFaçade(InputView inputView, OutputView outputView, Controller controller) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controller = controller;
    }

    public void start(){
        outputView.printStartMessage();
        outputView.printInputBridgeSizeMessage();
        Runnable runnable = controller.generateBridge(this,inputView.readBridgeSize());
        runnable.run();
    }

    public void moveBride(){
        outputView.printMoveMessage();
        HashMap<String, String> map = new HashMap<>();
        Runnable runnable = controller.moveBridge(this,inputView.readMoving(), map);
        outputView.printMap(map.get("bridge"));
        runnable.run();
    }

    public void reply(){
        outputView.printReplyMessage();
        Runnable replay = controller.replay(this,inputView.readGameCommand());
        replay.run();
    }

    public void end(BridgeStatusDto bridgeStatusDto){
        outputView.printResult(bridgeStatusDto.getBridge(),bridgeStatusDto.getSuccessOrFailure(),bridgeStatusDto.getCount());
    }
}
