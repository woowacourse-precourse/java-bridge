package bridge.view;

import static bridge.utils.Constant.CLEAR_OR_NOT_MESSAGE;
import static bridge.utils.Constant.ERROR;
import static bridge.utils.Constant.FINAL_SCORE_MESSAGE;
import static bridge.utils.Constant.RETRY_TOTAL_COUNT_MESSAGE;
import static bridge.utils.Constant.SPACE;
import static bridge.utils.Constant.START_MESSAGE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String bridge) {
        System.out.println(bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int retryCount, String clearOrNot) {
        System.out.println(CLEAR_OR_NOT_MESSAGE + clearOrNot);
        System.out.println(RETRY_TOTAL_COUNT_MESSAGE + retryCount);
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR + SPACE + errorMessage);
    }

    public void printFinalScoreMessage() {
        System.out.println(FINAL_SCORE_MESSAGE);
    }
}
