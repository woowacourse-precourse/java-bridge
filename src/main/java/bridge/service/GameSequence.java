package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.TryCount;
import bridge.view.InputView;
import bridge.view.OutputView;
public class GameSequence {

    public static void play(){
        OutputView.printStart();
        Bridge bridge = BridgeGame.generateBridge(InputView.readBridgeSize());
        TryCount tryCount = TryCount.initCount();
        tryCount = BridgeGame.getFinalResult(bridge, tryCount);
        OutputView.printResult(bridge, tryCount.getCount());
    }

}
