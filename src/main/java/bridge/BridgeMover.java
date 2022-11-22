package bridge;

import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.domain.State;
import bridge.validation.InputValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeMover {

    public BridgeMover() {

    }

    public void printCrossResults(List<Result> results) {
        OutputView outputView = new OutputView();
        results.forEach(outputView::printResult);
    }

    public List<Result> getCrossResults(List<Result> crossResults, boolean crossed, String direction) {
        List<Integer> movedDirection = Bridge.getBridgeByDirection(direction).getDirectionIndex();
        crossResults.get(movedDirection.get(0)).addResult(State.getStatusByCrossed(crossed));
        crossResults.get(movedDirection.get(1)).addResult(State.NOT_MOVED);
        return crossResults;
    }


    public String getDirectionFromInput() {
        new OutputView().printMoveDirectionSelectMessage();
        while (true) {
            try {
                return new InputValidation().getDirections(new InputView().readMoving());
            } catch (IllegalArgumentException exception) {
                new OutputView().printErrorMessage(exception.getMessage());
            }
        }
    }
}
