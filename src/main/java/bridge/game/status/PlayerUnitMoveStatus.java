package bridge.game.status;

import bridge.domain.code.GameStatus;
import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class PlayerUnitMoveStatus implements BridgeGameStatus {

    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {

        while (context.gameStatus().isRunning()) {
            context.movePlayerUnit(inputView.readMoving());
            outputView.printMap(context.getCachedHistory());
        }

        return verifyClearGame(context.gameStatus());
    }

    private BridgeGameStatus verifyClearGame(GameStatus gameStatus) {
        if (gameStatus.isClear()) {
            return new ResultVerificationStatus();
        }
        return new RestartGameStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
