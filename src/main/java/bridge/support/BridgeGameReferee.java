package bridge.support;

import bridge.MoveDirection;
import bridge.Result;
import bridge.view.OutputView;

public class BridgeGameReferee {

    public Result updateResult(Result result, MoveDirection direction, boolean isAnswer) {
        result.updateIsAnswers(direction, isAnswer);
        this.printMap(result);
        return result;
    }

    private void printMap(Result result) {
        OutputView outputView = new OutputView();
        outputView.printMap(result);
    }
}
