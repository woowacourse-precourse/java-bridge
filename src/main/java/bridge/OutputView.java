package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> printMap(String currentMoving, boolean isMatch, List<List<String>> prevResultMap) {
        List<String> currentResult = createCurrentResult(currentMoving, isMatch);
        System.out.print("[ ");
        if (prevResultMap.isEmpty()) {
            printOnlyCurrentResult(currentResult);
            return currentResult;
        }
        printEntireLine(prevResultMap, currentResult, 0);
        printEntireLine(prevResultMap, currentResult, 1);
        return currentResult;
    }

    private void printOnlyCurrentResult(List<String> currentResult) {
        System.out.print(currentResult.get(0));
        System.out.print(" ]\n");
        System.out.print("[ ");
        System.out.print(currentResult.get(1));
        System.out.print(" ]");
    }

    private void printEntireLine(List<List<String>> prevResultMap, List<String> currentResult, int line) {
        for (int i = 0; i < prevResultMap.size(); i++) {
            System.out.print(prevResultMap.get(i).get(line));
            System.out.print("|");
        }
        System.out.println(currentResult.get(line));
        System.out.print(" ]\n");
    }

    private String decidePrintMark(boolean isMatch) {
        if (isMatch) {
            return "O";
        }
        return "X";
    }

    private List<String> createCurrentResult(String currentMoving, boolean isMatch) {
        List<String> currentResult = new ArrayList<>();
        String mark = decidePrintMark(isMatch);
        if (currentMoving.equals("U")) {
            currentResult.add(mark);
            currentResult.add(" ");
            return currentResult;
        }
        currentResult.add(" ");
        currentResult.add(mark);
        return currentResult;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int attempts) {
        String suffix = decideSuccessOrFailure(isSuccess);
        System.out.println("게임 성공 여부: " + suffix);
        System.out.println("총 시도한 횟수: " + attempts);
    }

    private String decideSuccessOrFailure(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }

    public void requestStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void requestReadMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void requestReadGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}

