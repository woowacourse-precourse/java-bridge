package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;
import bridge.domain.Move;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {

    InputView inputView = new InputView();
    BridgeSize bridge = new BridgeSize();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Move mm = new Move();
    BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        String size = inputView.readBridgeSize();
        bridge.isNumber(size);
        bridge.isRangeNumber(size);
        int s = Integer.parseInt(size);
        List<String> bridge = bridgeMaker.makeBridge(s);
        System.out.println(bridge);
        for(int i=0;i<bridge.size();i++) {
            String move = inputView.readMoving();
            mm.isProper(move);

            bridgeGame.move(bridge.get(i), move);
        }


    }

}
