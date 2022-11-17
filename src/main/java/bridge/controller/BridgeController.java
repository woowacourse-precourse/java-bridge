package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Position;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    public void play() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<Integer> bridgeNumbers = bridgeMaker.makeBridge(3); // TODO: InputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeNumbers);
        System.out.println(bridge.getElements());
        Position position = new Position();
        BridgeGame bridgeGame = new BridgeGame();
        boolean isQuit = false;

        do {
            do {
                if (position.getIndex() == 3 - 1) { // TODO: size - 1
                    isQuit = true;
                    break;
                }
                String answer = InputView.readMoving();
                bridgeGame.move(answer, position);
            } while (OutputView.printMap(bridge, position).equals("O"));
            if (isQuit) {
                break;
            }
            bridgeGame.retry(position);
        } while (InputView.readGameCommand().equals("R"));
    }
}
