package bridge.view;

import bridge.domain.result.ResultType;
import bridge.domain.result.Result;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TOTAL_ATTEMPT = "총 시도한 횟수: ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printStartGame() {
        System.out.println(START_GAME);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        List<List<ResultType>> directionTypesGroup = result.getResultsGroup();
        for (List<ResultType> type : directionTypesGroup) {
            System.out.println(ResultType.reformatTypes(type));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result, int attempt) {
        printFinalMap(result);
        printFinalSuccessOrNot(result);
        printFinalAttempt(attempt);
    }

    private void printFinalMap(Result result) {
        System.out.println(FINAL_RESULT);
        printMap(result);
    }

    private void printFinalSuccessOrNot(Result result) {
        System.out.print(GAME_SUCCESS_OR_NOT);
        if (result.isContainWrongAnswer()) {
            System.out.println(FAIL);
        }
        if (!result.isContainWrongAnswer()) {
            System.out.println(SUCCESS);
        }
    }

    private void printFinalAttempt(int attempt) {
        System.out.print(TOTAL_ATTEMPT);
        System.out.println(attempt);
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
