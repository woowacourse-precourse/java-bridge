package bridge.service;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeResult;
import bridge.domain.game.Command;
import bridge.domain.game.SquareResult;
import bridge.dto.BridgeResultDto;
import bridge.dto.GameResultDto;

public class GameService {

    private BridgeResult bridgeResult = new BridgeResult();

    private BridgeGame bridgeGame;

    private int bridgeSize;

    public void initGame(BridgeGame bridgeGame, int bridgeSize) {
        this.bridgeGame = bridgeGame;
        this.bridgeSize = bridgeSize;
    }

    public BridgeResultDto getFormattedEachMoveResult(SquareResult result) {
        bridgeResult.updateResult(result);
        return bridgeResult.toDto();
    }

    public void isSuccessMoveBridge(SquareResult squareResult) {
        if (squareResult.isMoveSuccess()) {
            bridgeGame.move(bridgeSize);
        }
    }

    public void isEndOfBridgeExit() {
        if (bridgeGame.isGameSuccess(bridgeSize)) {
            bridgeGame.exitGame();
        }
    }

    public void restartOrExitGame(String input) {
        Command command = new Command(input);

        if (command.isExitCommand()) {
            bridgeGame.exitGame();
        }

        if (command.isRetryCommand()) {
            bridgeGame.retry();
            bridgeResult = new BridgeResult();
        }
    }

    public boolean inProgress() {
        return bridgeGame.isGameInProgress();
    }

    public GameResultDto getFinalGameResult() {
        return new GameResultDto(
                bridgeResult.toDto(),
                bridgeResult.getMoveSuccessResult(),
                bridgeGame.getRetryCount());
    }

    public int getCurrentPosition() {
        return bridgeGame.getPosition();
    }
}
