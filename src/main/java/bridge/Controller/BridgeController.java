package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.service.BridgePrinter;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgePrinter bridgePrinter;
    private BridgeGame bridgeGame;
    private Integer bridgeSize;
    private List<String> bridge;
    private int tryCount = 1;

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
        retryCheck();
        outputView.printMapResult(bridgePrinter.getUpBridge(), bridgePrinter.getDownBridge());
        outputView.printResult(successMessage(), tryCount);
    }

    private void retryCheck() {
        if (!bridgeGame.isSuccess()) {
            if(retry()){
                tryCount++;
                bridgeGame.retry();
                game();
            }
        }
    }

    private void game() {
        while(bridgeGame.isEnd()){
            System.out.println(bridge);
            bridgePrinter = bridgeGame.move(inputView.readMoving());
        }
    }

    public String successMessage(){
        if (bridgeGame.isSuccess()) {
            return "성공";
        }
        return "실패";
    }

    public boolean retry(){
        return inputView.readGameCommand();
    }
}
