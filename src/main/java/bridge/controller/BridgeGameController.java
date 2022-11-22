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
        List<String> bridge = makeBridge();

        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameRecord gameRecord = new GameRecord();

        playGame(bridgeGame, gameRecord);
    }

    private void playGame(BridgeGame bridgeGame, GameRecord gameRecord) {
        do {
            initializeGameRecord(gameRecord);
            moveUser(bridgeGame, gameRecord);

            if (gameRecord.isGameSuccess()) {
                makeResultModel(gameRecord);
                break;
            }
        } while (canRestart(bridgeGame));
    }

    private boolean canRestart(BridgeGame bridgeGame) {
        OutputView.printGameRestartRequest();
        String retryInput = InputView.readGameCommand();
        return bridgeGame.retry(retryInput);
    }

    private void initializeGameRecord(GameRecord gameRecord) {
        gameRecord.clear();
        gameRecord.updatePlayTime();
    }

    private List<String> makeBridge() {
        OutputView.printBridgeLengthRequest();
        int bridgeSize = InputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void makeResultModel(GameRecord gameRecord) {
        GameResultModel gameResultModel = new GameResultModel(gameRecord.makeBridgeRecord(),
                gameRecord.isGameSuccess(), gameRecord.getPlayTime());
        OutputView.printResult(gameResultModel);
    }

    private void moveUser(BridgeGame bridgeGame, GameRecord gameRecord) {
        for (int bridgeBlock = 0; bridgeGame.canExecute(bridgeBlock); bridgeBlock++) {
            boolean success = moveOneBlock(bridgeGame, gameRecord, bridgeBlock);
            if (!success) {
                break;
            }
        }
    }

    private boolean moveOneBlock(BridgeGame bridgeGame, GameRecord gameRecord, int bridgeBlock) {
        OutputView.printUserMoveRequest();
        String direction = InputView.readMoving();
        boolean success = bridgeGame.move(direction, bridgeBlock);
        gameRecord.addRecord(direction, success);

        BridgeStatusModel bridgeStatusModel = new BridgeStatusModel(gameRecord.makeBridgeRecord());
        OutputView.printMap(bridgeStatusModel);
        return success;
    }
}
