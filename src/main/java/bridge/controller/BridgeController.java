package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.PassingPositions;
import bridge.domain.Position;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    public void play() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        String input = InputView.readBridgeSize();
        int size = Integer.parseInt(input);
        List<String> bridgeNumbers = bridgeMaker.makeBridge(size);

        Bridge bridge = new Bridge(bridgeNumbers);

        System.out.println(bridge.getElements());

//        Position position = new Position();
//        PassingPositions passingPositions = new PassingPositions();
        BridgeGame bridgeGame = new BridgeGame();
        boolean isQuit = false;

        do {
            Position position = new Position();
            PassingPositions passingPositions = new PassingPositions();
//            BridgeGame bridgeGame = new BridgeGame();
            do {
                if (position.getIndex() == size - 1) {
                    isQuit = true;
                    break;
                }
                String answer = InputView.readMoving();
                bridgeGame.move(answer, position, passingPositions);
            } while (!OutputView.printMap(bridge, passingPositions).contains("X"));

            if (isQuit) {
                break;
            }
            bridgeGame.retry(passingPositions);
        } while (InputView.readGameCommand().equals("R"));
    }
}
