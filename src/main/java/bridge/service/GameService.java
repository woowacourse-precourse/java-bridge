package bridge.service;

import bridge.domain.bridge.Square;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeResult;
import bridge.domain.game.Command;
import bridge.domain.game.SquareResult;
import bridge.dto.BridgeResultDto;
import bridge.dto.GameResultDto;

public class GameService {

    private final BridgeGame bridgeGame;

    private BridgeResult bridgeResult = new BridgeResult();

    public GameService(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public BridgeResultDto getFormattedEachMoveResult(SquareResult result) {
        bridgeResult.updateResult(result);
        return bridgeResult.toDto();
    }

    public SquareResult moveBridge(String move) {
        Square userSquare = Square.of(move);
        return bridgeGame.move(userSquare);
    }

    public boolean isFinalSuccess() {
        return bridgeGame.isFinalSuccess() && bridgeResult.isSuccess();

    }

    public boolean canContinueRound() {
        return !bridgeGame.isFinalSuccess() && bridgeResult.isSuccess();
    }

    public boolean isRestart(String input) {
        Command command = new Command(input);
        if (command.isExitCommand()) {
            return false;
        }

        bridgeGame.retry();
        bridgeResult = new BridgeResult();
        return true;
    }

    public GameResultDto getFinalGameResult() {
        return new GameResultDto(
                bridgeResult.toDto(),
                bridgeResult.getMoveSuccessResult(),
                bridgeGame.getRetryCount());
    }
}
