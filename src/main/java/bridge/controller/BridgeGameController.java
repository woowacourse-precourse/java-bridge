package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameRecord;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.model.BridgeStatusModel;
import bridge.model.GameResultModel;
import java.util.List;

public class BridgeGameController {

    public void start() {
        OutputView.printStart();
        OutputView.printBridgeLengthRequest();
        int bridgeSize = InputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);


        BridgeGame bridgeGame = new BridgeGame();

        int playtime = 0;
        boolean retryflag = true;

        do {
            GameRecord gameRecord = new GameRecord();
            playtime++;

            for (int bridgeBlock = 0; bridgeBlock < bridgeSize; bridgeBlock++) {
                OutputView.printUserMoveRequest();
                String direction = InputView.readMoving();
                boolean success = bridgeGame.move(direction, bridgeBlock, bridge);

                gameRecord.addRecord(direction, success);

                BridgeStatusModel bridgeStatusModel = new BridgeStatusModel(gameRecord.makeBridgeRecord());
                OutputView.printMap(bridgeStatusModel);
                if (!success) {
                    break;
                }
            }

            OutputView.printGameRestartRequest();
            String s = InputView.readGameCommand();
            retryflag = bridgeGame.retry(s);

            if (!retryflag) {
                GameResultModel gameResultModel = new GameResultModel(gameRecord.makeBridgeRecord(),
                        gameRecord.isGameSuccess(), playtime);
                OutputView.printResult(gameResultModel);
            }
        } while (retryflag);

    }
}
