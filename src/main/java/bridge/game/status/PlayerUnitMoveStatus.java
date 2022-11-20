package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public class PlayerUnitMoveStatus implements BridgeGameStatus {

    @Override
    public BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView) {
        var game = context.getBridgeGame();
        context.plusRepeatCount();

        while (game.canPlayerMove()) {
            var movePosition = bridgeGameView.getInputView().readMoving();
            var history = game.move(movePosition);
            var resultHistory = history.resultByPositions();
            context.writeHistory(resultHistory);
            bridgeGameView.getOutputView().printMap(resultHistory);
        }

        if (game.isClear()) {
            return new ResultVerificationStatus();
        }

        var restartCommand = bridgeGameView.getInputView().readGameCommand();
        if (restartCommand.isContinue()) {
            return new RestartGameStatus();
        }
        return new ResultVerificationStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
