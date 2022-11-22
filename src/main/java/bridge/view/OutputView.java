package bridge.view;

import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;

import static bridge.constants.OutputMessage.*;
import static bridge.domain.Result.*;

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
        printForm.add(makeUpForm(up, results));
        printForm.add(makeDownForm(down, results));
        return printForm;
    }

    private List<String> makeUpForm(List<String> up, List<Result> results) {
        for (int i = 0; i < results.size(); i++) {
            up.add(choseUpFormMark(results.get(i)));
        }
        return up;
    }

    private String choseUpFormMark(Result result) {
        if (result == UP_SUCCESS) {
            return UP_SUCCESS.getAcceptability();
        }
        if (result == DOWN_FAIL) {
            return DOWN_FAIL.getAcceptability();
        }
        return " ";
    }

    private List<String> makeDownForm(List<String> down, List<Result> results) {
        for (int i = 0; i < results.size(); i++) {
            down.add(choseDownFormMark(results.get(i)));
        }
        return down;
    }

    private String choseDownFormMark(Result result) {
        if (result == UP_FAIL) {
            return UP_FAIL.getAcceptability();
        }
        if (result == DOWN_SUCCESS) {
            return DOWN_SUCCESS.getAcceptability();
        }
        return " ";
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
        System.out.println(GAME_SUCCESS_MESSAGE.getMessage());
    }

    public void printFail() {
        System.out.println(GAME_FAIL_MESSAGE.getMessage());
    }
}
