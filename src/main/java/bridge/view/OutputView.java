package bridge.view;

import static bridge.utils.BridgeConstant.END_POINT_MARKING;
import static bridge.utils.BridgeConstant.MIDDLE_POINT_MARKING;
import static bridge.utils.BridgeConstant.MOVING_FAIL_MARKING;
import static bridge.utils.BridgeConstant.MOVING_SUCCESS_MARKING;
import static bridge.utils.BridgeConstant.NOTHING_MARKING;
import static bridge.utils.BridgeConstant.STARTING_POINT_MARKING;
import static bridge.utils.command.MoveCommand.DOWN;
import static bridge.utils.command.MoveCommand.UP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param movingData
     * @param movingResults
     */
    public void printMap(List<String> movingData, List<Boolean> movingResults) {
        List<String> topLineMap = new ArrayList<>();
        List<String> bottomLineMap = new ArrayList<>();

        for (int movingResultsIndex = 0; movingResultsIndex < movingResults.size(); movingResultsIndex++) {
            if (Objects.equals(movingData.get(movingResultsIndex), UP.getCommand())) {
                topLineMap.add(markMovingSuccessOrFail(movingResults, movingResultsIndex));
                bottomLineMap.add(NOTHING_MARKING);
            }
            if (Objects.equals(movingData.get(movingResultsIndex), DOWN.getCommand())) {
                bottomLineMap.add(markMovingSuccessOrFail(movingResults, movingResultsIndex));
                topLineMap.add(NOTHING_MARKING);
            }
        }
        System.out.println(formatMap(topLineMap) + "\n" + formatMap(bottomLineMap));
    }

    private String markMovingSuccessOrFail(List<Boolean> movingResults, int movingResultsIndex) {
        if (Boolean.TRUE.equals(movingResults.get(movingResultsIndex))) {
            return MOVING_SUCCESS_MARKING;
        }
        return MOVING_FAIL_MARKING;
    }

    private String formatMap(List<String> lineMap) {
        return lineMap.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(MIDDLE_POINT_MARKING, STARTING_POINT_MARKING, END_POINT_MARKING));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
