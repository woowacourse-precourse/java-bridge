package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;
    private Integer bridgeSize;
    private List<String> bridge;

    public BridgeController() {
        outputView.printStartMessage();
        init();
    }
    public void init(){
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
    }
    public void run(){
        game();
        outputView.printResult(successMessage(), 1);
    }

    private void game() {
        while(bridgeGame.isEnd()){
            System.out.println(bridge);
            bridgeGame.move(inputView.readMoving());
        }
    }

    public String successMessage(){
        if (bridgeGame.isSuccess()) {
            return "성공";
        }
        return "실패";
    }
}
