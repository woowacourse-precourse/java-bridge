package bridge.support;

import bridge.MoveDirection;
import bridge.Result;
import bridge.view.OutputView;

public class BridgeGameReferee {

    private final OutputView outputView;

    public BridgeGameReferee(OutputView outputView) {
        this.outputView = outputView;
    }

    public Result updateResult(Result result, MoveDirection direction, boolean isAnswer) {
        result.updateIsAnswers(direction, isAnswer);
        this.printMap(result);
        return result;
    }

    private void printMap(Result result) {
        outputView.printMap(result);
    }
}
