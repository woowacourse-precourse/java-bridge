package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();

    public void start(){
        outputView.printStartMessage();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        List<List<String>> results = new ArrayList<>();
        int count = 0;
        while(true){
            String moving = inputView.readMoving();
            results = bridgeGame.move(bridge,moving,count);
            System.out.println(results);
            count++;
        }

    }
}
