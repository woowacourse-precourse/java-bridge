package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> correctBridge = bridgeGame.makeCorrectBridge(InputView.readBridgeSize());
        OutputView outputView = new OutputView();
        while(true) {
            int stopPlaying = outputView.printMap(correctBridge);
            if(stopPlaying == 1 ) { break; }
            if(stopPlaying == 2 ) { break; }
        } outputView.printResult();
    }
}