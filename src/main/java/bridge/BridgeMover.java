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

    public List<Result> moveBridges(List<String> bridges, List<Result> crossResults, int position) {
        crossResults = getCrossResults(bridges, crossResults, position);
        printCrossResults(crossResults);
        return crossResults;
    }

    public void printCrossResults(List<Result> results) {
        OutputView outputView = new OutputView();
        results.forEach(outputView::printResult);
    }

    public List<Result> getCrossResults(List<String> bridges, List<Result> crossResults, int position) {
        boolean crossed = canCrossBridge(bridges, position);
        List<Integer> movedDirection = getMovedDirection(bridges, position);
        crossResults.get(movedDirection.get(0)).addResult(State.getStatusByCrossed(crossed));
        crossResults.get(movedDirection.get(1)).addResult(State.NOT_MOVED);
        return crossResults;
    }

    public boolean canCrossBridge(List<String> bridges, int position) {
        OutputView outputView = new OutputView();
        outputView.printMoveDirectionSelectMessage();
        String direction = getDirectionFromInput();
        return bridges.get(position).equals(direction);
    }

    public String getDirectionFromInput() {
        InputView inputView = new InputView();
        InputValidation inputValidation = new InputValidation();
        while (true) {
            try {
                return inputValidation.getDirections(inputView.readMoving());
            } catch (IllegalArgumentException exception) {
                new OutputView().printErrorMessage(exception.getMessage());
            }
        }
    }

    public List<Integer> getMovedDirection(List<String> bridges, int position) {
        if (bridges.get(position).equals(Bridge.DOWN.getDirection())) {
            return List.of(0, 1);
        }
        return List.of(1, 0);
    }
}
