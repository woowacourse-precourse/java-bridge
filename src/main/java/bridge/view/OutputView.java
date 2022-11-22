package bridge.view;

import bridge.domain.model.GameResult;
import bridge.domain.model.ScoreMap;
import bridge.view.utils.OutputUtils;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_HEAD_MESSAGE = "[ERROR] ";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String GAME_TRY_MESSAGE = "총 시도한 횟수: ";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";

    private OutputView() {
    }

    public static void printException(Exception exception) {
        OutputUtils.output(ERROR_HEAD_MESSAGE + exception.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param scoreMap
     */
    public static void printMap(ScoreMap scoreMap) {
        OutputUtils.outputLine(scoreMap.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param gameResult
     */
    public static void printResult(GameResult gameResult) {
        OutputUtils.outputLine(FINAL_RESULT_MESSAGE);
        OutputUtils.outputLine(gameResult.getScoreMap());
        OutputUtils.outputLine(GAME_RESULT_MESSAGE + gameResult.getResult());
        OutputUtils.outputLine(GAME_TRY_MESSAGE + gameResult.getTryCount());
    }

}
