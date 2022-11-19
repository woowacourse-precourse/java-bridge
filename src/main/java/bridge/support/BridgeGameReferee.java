package bridge.support;

import bridge.BridgeGame;
import bridge.MoveDirection;
import bridge.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameReferee {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameReferee(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Result doJudge(int bridgeSize, BridgeGame bridgeGame) {
        Result result = new Result();

        for (int i = 0; i < bridgeSize; i++) {
            MoveDirection direction = this.readMoving();
            result.updateIsAnswers(direction, bridgeGame.move(direction, i));
            this.printMap(result);
            if(result.hasWrong()) {
                return result;
            }
        }
        return result;
    }

    private MoveDirection readMoving() {
        outputView.printInputMoveDirection();
        return inputView.readMoving();
    }

    private void printMap(Result result) {
        outputView.printMap(result);
    }
}
