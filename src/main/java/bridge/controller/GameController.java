package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameControl;
import bridge.domain.GameStatusDTO;
import bridge.view.OutputView;

public class GameController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();

    public void run() {
        initializeGame();
        GameStatusDTO finalGameStatusDTO = getFinalGameResult();
        outputView.printResult(finalGameStatusDTO);
    }

    private void initializeGame() {
        int size = inputController.readBridgeSizeUntilSucceed();
        bridgeGame.initAnswerBridge(size);
    }

    private GameStatusDTO getFinalGameResult() {
        GameStatusDTO finalGameResult;
        do {
            finalGameResult = getOneGameResult();
        } while (!isGameOver(finalGameResult));

        return finalGameResult;
    }

    private GameStatusDTO getOneGameResult() {
        GameStatusDTO gameStatusDTO;
        do {
            String moving = inputController.readMovingUntilSucceed();
            gameStatusDTO = bridgeGame.getMovingResult(moving);
            outputView.printMap(gameStatusDTO);
        } while (gameStatusDTO.isPlaying());
        return gameStatusDTO;
    }

    private boolean isGameOver(GameStatusDTO gameStatusDTO) {
        return gameStatusDTO.isClear() || needExit();
    }

    private boolean needExit() {
        String gameCommand = inputController.readGameCommandUntilSucceed();
        if (GameControl.isQuit(gameCommand)) {
            return true;
        }
        bridgeGame.retry();
        return false;
    }
}
