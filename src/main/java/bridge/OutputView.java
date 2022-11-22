package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.OutputMessage.*;
import static bridge.Result.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE.getMessage());
    }

    public void printMap(List<Result> results) {
        List<List<String>> printForm = makePrintForm(results);
        String up = String.join(" | ", printForm.get(0));
        String down = String.join(" | ", printForm.get(1));
        System.out.println("[ " + up + " ]");
        System.out.println("[ " + down + " ]");
    }

    private List<List<String>> makePrintForm(List<Result> results) {
        List<List<String>> printForm = new ArrayList<>();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i) == UP_SUCCESS) {
                up.add(UP_SUCCESS.getAcceptability());
                down.add(" ");
            }
            if (results.get(i) == UP_FAIL) {
                up.add(" ");
                down.add(UP_FAIL.getAcceptability());
            }
            if (results.get(i) == DOWN_SUCCESS) {
                up.add(" ");
                down.add(DOWN_SUCCESS.getAcceptability());
            }
            if (results.get(i) == DOWN_FAIL) {
                up.add(DOWN_FAIL.getAcceptability());
                down.add(" ");
            }
        }
        printForm.add(up);
        printForm.add(down);
        return printForm;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Result> results) {
        System.out.println(FINAL_GAME_RESULT_MESSAGE.getMessage());
        List<List<String>> printForm = makePrintForm(results);
        String up = String.join(" | ", printForm.get(0));
        String down = String.join(" | ", printForm.get(1));
        System.out.println("[ " + up + " ]");
        System.out.println("[ " + down + " ]");
    }

    public void printTotalTryCount(int totalTryCount) {
        System.out.println(TOTAL_TRY_COUNT_MESSAGE.getMessage() + totalTryCount);
    }

    public void printSuccess() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    public void printFail() {
        System.out.println(GAME_FAIL_MESSAGE);
    }
}
