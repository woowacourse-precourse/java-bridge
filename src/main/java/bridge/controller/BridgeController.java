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

        String input = InputView.readBridgeSize();
        int size = Integer.parseInt(input);
        List<String> bridgeNumbers = bridgeMaker.makeBridge(size);

        Bridge bridge = new Bridge(bridgeNumbers);

        System.out.println(bridge.getElements());

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
                boolean isUpAndDownValid = true;
                do {
                    try {
                        answer = InputView.readMoving();
                        isUpAndDownValid = true;
                    } catch (IllegalArgumentException ex) {
                        isUpAndDownValid = false;
                        OutputView.printError(ex.getMessage());
                    }
                } while(!isUpAndDownValid);

                bridgeGame.move(pos, answer, passingPositions);
                result = new Result(bridge, passingPositions);

            } while (!OutputView.printMap(result).contains("X"));


            if (isQuit) {
                break;
            }


            String ans = "";
            boolean isRetryOrQuitValid = true;
            do {
                try {
                    ans = InputView.readGameCommand();
                    isRetryOrQuitValid = true;
                    if (ans.equals("Q")) {
                        break game;
                    }
                } catch (IllegalArgumentException ex) {
                    isRetryOrQuitValid = false;
                    OutputView.printError(ex.getMessage());
                }
            } while(!isRetryOrQuitValid);



            bridgeGame.retry(passingPositions);
            attempt++;
        }

        if (result != null) {
            OutputView.printResult(result, attempt);
        }
    }
}
