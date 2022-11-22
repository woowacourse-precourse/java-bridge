package bridge;

import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.domain.State;
import bridge.validation.InputValidation;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @return 사용자가 입력한 다리의 길이를 반환한다.
     */
    public int gameStart() {
        OutputView outputView = new OutputView();
        outputView.printStartMessage();
        while (true) {
            try {
                return new InputValidation().getValue(new InputView().readBridgeSize());
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();
        while (bridges.size() < size) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridges.add(Arrays.stream(Bridge.values())
                    .filter(bridge -> bridge.isSameNumber(randomNumber))
                    .findAny()
                    .get()
                    .getDirection());
        }
        return bridges;
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
        boolean crossed = crossBridge(bridges, position);
        List<Integer> movedDirection = getMovedDirection(bridges, position);
        crossResults.get(movedDirection.get(0)).addResult(State.getStatusByCrossed(crossed));
        crossResults.get(movedDirection.get(1)).addResult(State.NOT_MOVED);
        return crossResults;
    }

    public boolean crossBridge(List<String> bridges, int position) {
        OutputView outputView = new OutputView();
        outputView.printMoveDirectionSelectMessage();
        String direction = getDirectionFromInput();
        return new BridgeGame().move(bridges, position, direction);
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
