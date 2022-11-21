package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private static BridgeMaker bridgeMaker;
    private static BridgeSizeInputException bridgeSizeInputException;
    private CurrentLocationInformation currentLocationInformation = new CurrentLocationInformation();

    public Controller() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    private void init() {

    }

    public void startGame() {
        try {
            int count = 0;
            int challengeCount = 1;
            boolean game = true;
            InputView inputView = new InputView();
            int bridgeSize = inputView.readBridgeSize();

            List<String> test = new ArrayList<>();
            OutputView outputView = new OutputView();

            test = bridgeMaker.makeBridge(bridgeSize);
            for (String s : test) {
                System.out.print(s + " ");
            }
            System.out.println();
            BridgeGame bridgeGame = new BridgeGame();

            while (game) {
                String moving = inputView.readMoving();
                game = bridgeGame.move(test, moving, count);

                count++;

                if (game == false && count < bridgeSize) {
                    game = bridgeGame.retry(inputView.readGameCommand());
                    if (game == false) {
                        outputView.printResult(currentLocationInformation, challengeCount, game);
                    }
                    count = 0;
                    challengeCount++;
                    CurrentLocationInformation.init();
                }

                if (game == false && count == bridgeSize) {
                    game = bridgeGame.retry(inputView.readGameCommand());
                    if (game == false) {
                        outputView.printResult(currentLocationInformation, challengeCount, game);
                    }
                    count = 0;
                    challengeCount++;
                    CurrentLocationInformation.init();
                }


                if (game == true && count == bridgeSize) {
                    outputView.printResult(currentLocationInformation, challengeCount, game);
                    game = false;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
