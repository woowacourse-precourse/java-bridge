package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    String correct = "O";
    String notSelected = "   ";
    String wrong = " X ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> printMap(List<String> bridgeAnswer, List<String> currentResult, Boolean userChoice, int stage) {
        if (userChoice) {
            currentResult = printMapCorrect(bridgeAnswer, currentResult, stage);
        }
        if (!userChoice) {
            currentResult = printMapWrong(bridgeAnswer, currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapNextRow(List<String> previousRowResult) {
        List<String> nextRowMap = new ArrayList<>();
        for (int index = 0; index < previousRowResult.size(); index++) {
            if (previousRowResult.get(index).equals(correct)||previousRowResult.get(index).equals(wrong)) {
                nextRowMap.add(notSelected);
            }
            if (previousRowResult.get(index).equals(notSelected)) {
                nextRowMap.add(correct);
            }
        }
        return nextRowMap;
    }

    public List<String> printMapCorrect(List<String> bridgeAnswer, List<String> currentResult, int stage) {
        if (bridgeAnswer.get(stage).equals("U")) {
            currentResult.add(correct);
        }
        if (bridgeAnswer.get(stage).equals("D")) {
            currentResult.add(notSelected);
        }
        return currentResult;
    }

    public List<String> printMapWrong(List<String> bridgeAnswer, List<String> currentResult, int stage) {
        if (bridgeAnswer.get(stage).equals("D")) {
            currentResult.add(wrong);
        }
        if (bridgeAnswer.get(stage).equals("U")) {
            currentResult.add(notSelected);
        }

        return currentResult;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

        System.out.println("최종 게임 결과");

    }
}
