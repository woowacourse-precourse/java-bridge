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

        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameRecord gameRecord = new GameRecord();

        boolean retryflag = true;

        do {
            gameRecord.clear();
            gameRecord.updatePlayTime();

            moveUser(bridgeGame, gameRecord);
            if (gameRecord.isGameSuccess()) {
                GameResultModel gameResultModel = new GameResultModel(gameRecord.makeBridgeRecord(),
                        gameRecord.isGameSuccess(), gameRecord.getPlayTime());
                OutputView.printResult(gameResultModel);
                break;
            }

            OutputView.printGameRestartRequest();
            String s = InputView.readGameCommand();
            retryflag = bridgeGame.retry(s);

        } while (retryflag);
    }

    private void moveUser(BridgeGame bridgeGame, GameRecord gameRecord) {
        for (int bridgeBlock = 0; bridgeGame.canExecute(bridgeBlock); bridgeBlock++) {
            boolean success = moveOneBlock(bridgeGame, gameRecord, bridgeBlock);
            if (!success) {
                break;
            }
        }
    }

    private static boolean moveOneBlock(BridgeGame bridgeGame, GameRecord gameRecord, int bridgeBlock) {
        OutputView.printUserMoveRequest();
        String direction = InputView.readMoving();
        boolean success = bridgeGame.move(direction, bridgeBlock);
        gameRecord.addRecord(direction, success);

        BridgeStatusModel bridgeStatusModel = new BridgeStatusModel(gameRecord.makeBridgeRecord());
        OutputView.printMap(bridgeStatusModel);
        return success;
    }
}
