package bridge.game.status;

import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class PlayerUnitMoveStatus implements BridgeGameStatus {

    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        var game = context.getBridgeGame();
        context.plusRepeatCount();

        while (game.canPlayerMove()) {
            var movePosition = inputView.readMoving();
            var history = game.move(movePosition);
            var resultHistory = history.resultByPositions();
            context.writeHistory(resultHistory);
            outputView.printMap(resultHistory);
        }

        if (game.isClear()) {
            return new ResultVerificationStatus();
        }

        var restartCommand = inputView.readGameCommand();
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
