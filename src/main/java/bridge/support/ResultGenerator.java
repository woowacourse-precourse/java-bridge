package bridge.support;

import bridge.BridgeGame;
import bridge.MoveDirection;
import bridge.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public final class ResultGenerator {

    private ResultGenerator() {}

    public static Result generateResult(int bridgeSize, BridgeGame bridgeGame) {
        Result result = new Result();

        for (int i = 0; i < bridgeSize; i++) {
            MoveDirection direction = readMoving();
            result.updateIsAnswers(direction, bridgeGame.move(direction, i));
            printMap(result);
        }
        return result;
    }

    private static MoveDirection readMoving() {
        InputView inputView = new InputView();
        return inputView.readMoving();
    }

    private static void printMap(Result result) {
        OutputView outputView = new OutputView();
        outputView.printMap(result);
    }
}
