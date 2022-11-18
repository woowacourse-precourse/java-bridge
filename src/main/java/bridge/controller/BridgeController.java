package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.PassingPositions;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    public void play() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


        String inputLength = "";
        do {
            try {
                inputLength = InputView.readBridgeSize();
            } catch (IllegalArgumentException ex) {
                OutputView.printError(ex.getMessage());
            }
        } while(inputLength.isBlank());


        int size = Integer.parseInt(inputLength);
        List<String> bridgeNumbers = bridgeMaker.makeBridge(size);

        Bridge bridge = new Bridge(bridgeNumbers);

        System.out.println(bridge.getDirections());

        BridgeGame bridgeGame = new BridgeGame();
        boolean isQuit = false;
        int pos;
        int attempt = 1;

        PassingPositions passingPositions = new PassingPositions();
        Result result = null;

        game:
        while(true) {
            pos = -1;
            do {
                pos++;
                if (pos == size) {
                    isQuit = true;
                    break;
                }

                String answer = "";
                do {
                    try {
                        answer = InputView.readMoving();
                    } catch (IllegalArgumentException ex) {
                        OutputView.printError(ex.getMessage());
                    }
                } while(answer.isBlank());

                bridgeGame.move(pos, answer, passingPositions);
                result = new Result(bridge, passingPositions);

            } while (!OutputView.printMap(result).contains("X"));


            if (isQuit) {
                break;
            }


            String ans = "";
            do {
                try {
                    ans = InputView.readGameCommand();
                    if (ans.equals("Q")) {
                        break game;
                    }
                } catch (IllegalArgumentException ex) {
                    OutputView.printError(ex.getMessage());
                }
            } while(ans.isBlank());



            bridgeGame.retry(passingPositions);
            attempt++;
        }

        if (result != null) {
            OutputView.printResult(result, attempt);
        }
    }
}
