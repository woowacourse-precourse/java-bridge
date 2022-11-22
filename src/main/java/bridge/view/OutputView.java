package bridge.view;

import static bridge.utils.BridgeConstant.END_POINT_MARKING;
import static bridge.utils.BridgeConstant.FAIL;
import static bridge.utils.BridgeConstant.MIDDLE_POINT_MARKING;
import static bridge.utils.BridgeConstant.MOVING_FAIL_MARKING;
import static bridge.utils.BridgeConstant.MOVING_SUCCESS_MARKING;
import static bridge.utils.BridgeConstant.NOTHING_MARKING;
import static bridge.utils.BridgeConstant.STARTING_POINT_MARKING;
import static bridge.utils.BridgeConstant.SUCCESS;
import static bridge.utils.command.MoveCommand.DOWN;
import static bridge.utils.command.MoveCommand.UP;
import static bridge.utils.message.FixedMessage.GAME_RESULT;
import static bridge.utils.message.FixedMessage.GAME_START;
import static bridge.utils.message.FixedMessage.SUCCESS_OR_FAIL;
import static bridge.utils.message.FixedMessage.TOTAL_ATTEMPTS;

import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;
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
     * @param bridgeGame
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> topLineMap = new ArrayList<>();
        List<String> bottomLineMap = new ArrayList<>();

        makeLineMap(bridgeGame, topLineMap, bottomLineMap);

        System.out.println(formatMap(topLineMap));
        System.out.println(formatMap(bottomLineMap));
    }

    private void makeLineMap(BridgeGame bridgeGame, List<String> topLineMap, List<String> bottomLineMap) {
        for (int index = 0; index < bridgeGame.getMovingCount(); index++) {
            if (UP.equalCommand(bridgeGame.findMovingByIndex(index))) {
                topLineMap.add(markMovingSuccessOrFail(bridgeGame.findMovingResultByIndex(index)));
                bottomLineMap.add(NOTHING_MARKING);
            }
            if (DOWN.equalCommand(bridgeGame.findMovingByIndex(index))) {
                bottomLineMap.add(markMovingSuccessOrFail(bridgeGame.findMovingResultByIndex(index)));
                topLineMap.add(NOTHING_MARKING);
            }
        }
    }

    private String markMovingSuccessOrFail(Boolean movingResult) {
        if (Boolean.TRUE.equals(movingResult)) {
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
     *
     * @param bridgeGame
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("\n" + GAME_RESULT.getMessage());
        printMap(bridgeGame);
        System.out.println(
                "\n" + String.format(SUCCESS_OR_FAIL.getMessage(), printSuccessOrFail(bridgeGame.isMovingFail())));
        System.out.println(String.format(TOTAL_ATTEMPTS.getMessage(), bridgeGame.getTotalAttempts()));
    }

    private String printSuccessOrFail(boolean isMovingFail) {
        if (isMovingFail) {
            return FAIL;
        }
        return SUCCESS;
    }

    public void printGameStart() {
        System.out.println(GAME_START.getMessage() + "\n");
    }
}
