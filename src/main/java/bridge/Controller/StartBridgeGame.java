package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class StartBridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static List<String> bridge;

    public void run(){
        printStartGame();
        makeBridge(inputView.readBridgeSize());

    }

    private void printStartGame(){
        outputView.printStartGameNotice();
        outputView.printInputBridgeSizeNotice();
    }

    private void makeBridge(int size){
        bridge = bridgeMaker.makeBridge(size);
    }
}
