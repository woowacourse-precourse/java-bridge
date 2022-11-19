package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Result.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private List<Result> results = new ArrayList<>();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        addResult(result);
        List<List<String>> printForm = makePrintForm();
        String up = String.join(" | ", printForm.get(0));
        String down = String.join(" | ", printForm.get(1));
        System.out.println("[ " + up + " ]");
        System.out.println("[ " + down + " ]");
    }

    private void addResult(Result result) {
        results.add(result);
    }

    private List<List<String>> makePrintForm() {
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
    public void printResult() {
    }
}
