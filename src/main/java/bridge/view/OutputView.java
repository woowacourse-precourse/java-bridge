package bridge.view;

import static bridge.util.Constants.OUTPUT_LINE_BREAK;
import static bridge.util.Constants.OUTPUT_ATTEMPTS;
import static bridge.util.Constants.OUTPUT_ENGER_MOVING;
import static bridge.util.Constants.OUTPUT_ENTER_BRIDGE_SIZE;
import static bridge.util.Constants.OUTPUT_ENTER_RETRY_OR_QUIT;
import static bridge.util.Constants.OUTPUT_FINAL_RESULT;
import static bridge.util.Constants.OUTPUT_START_GAME;
import static bridge.util.Constants.OUTPUT_SUCCESS_OR_FAIL;
import static bridge.util.ErrorMessage.ERROR_MESSAGE;

import bridge.model.Diagram;
import bridge.model.SuccessAndFail;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Diagram diagram) {
        diagram.getFormattedDiagrams().forEach(element -> System.out.println(element));
        System.out.println(OUTPUT_LINE_BREAK);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Diagram diagram, SuccessAndFail successOrFail, int attempts) {
        System.out.println(OUTPUT_FINAL_RESULT);
        printMap(diagram);
        System.out.println(OUTPUT_LINE_BREAK);
        System.out.println(OUTPUT_SUCCESS_OR_FAIL + successOrFail.getKoreanDisplay());
        System.out.println(OUTPUT_ATTEMPTS + attempts);
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.printf(ERROR_MESSAGE, exception.getMessage());
    }

    public void printStartGame() {
        System.out.println(OUTPUT_START_GAME);
        System.out.println(OUTPUT_LINE_BREAK);
    }

    public void printBridgeSizeInput() {
        System.out.println(OUTPUT_ENTER_BRIDGE_SIZE);
        System.out.println();
    }

    public void printMoveInput() {
        System.out.println(OUTPUT_ENGER_MOVING);
    }

    public void printGameCommandInput() {
        System.out.println(OUTPUT_ENTER_RETRY_OR_QUIT);
    }
}
