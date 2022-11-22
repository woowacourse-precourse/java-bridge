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

    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final InputView INPUT_VIEW = new InputView();

    public void start() {
        OUTPUT_VIEW.printStart();
        List<String> bridge = makeBridge();

        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameRecord gameRecord = new GameRecord();

        GameResultModel gameResultModel = playGame(bridgeGame, gameRecord);
        OUTPUT_VIEW.printResult(gameResultModel);
    }

    private GameResultModel playGame(BridgeGame bridgeGame, GameRecord gameRecord) {
        do {
            initializeGameRecord(gameRecord);
            moveUser(bridgeGame, gameRecord);

            if (gameRecord.isGameSuccess()) {
                 break;
            }
        } while (canRestart(bridgeGame));

        return makeResultModel(gameRecord);
    }

    private boolean canRestart(BridgeGame bridgeGame) {
        OUTPUT_VIEW.printGameRestartRequest();
        String retryInput = INPUT_VIEW.readGameCommand();
        return bridgeGame.retry(retryInput);
    }

    private void initializeGameRecord(GameRecord gameRecord) {
        gameRecord.clear();
        gameRecord.updatePlayTime();
    }

    private List<String> makeBridge() {
        OUTPUT_VIEW.printBridgeLengthRequest();
        int bridgeSize = INPUT_VIEW.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private GameResultModel makeResultModel(GameRecord gameRecord) {
        return new GameResultModel(gameRecord.makeBridgeRecord(),
                gameRecord.isGameSuccess(), gameRecord.getPlayTime());
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
        OUTPUT_VIEW.printUserMoveRequest();
        String direction = INPUT_VIEW.readMoving();
        boolean success = bridgeGame.move(direction, bridgeBlock);
        gameRecord.addRecord(direction, success);

        BridgeStatusModel bridgeStatusModel = new BridgeStatusModel(gameRecord.makeBridgeRecord());
        OUTPUT_VIEW.printMap(bridgeStatusModel);
        return success;
    }
}
