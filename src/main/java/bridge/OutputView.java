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
    public List<String> printMap(List<String> bridgeAnswer, List<String> currentResult, Boolean userChoice, int stage) {
        if (userChoice) {
            currentResult = printMapCorrect(bridgeAnswer, currentResult, stage);
        }
        if (!userChoice) {
            currentResult = printMapWrong(bridgeAnswer, currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapCorrect(List<String> bridgeAnswer, List<String> currentResult, int stage) {
        if (bridgeAnswer.get(stage).equals("U")) {
            currentResult = printMapUpsideCorrect(currentResult, stage);
        }
        if (bridgeAnswer.get(stage).equals("D")) {
            currentResult = printMapDownsideCorrect(currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapWrong(List<String> bridgeAnswer, List<String> currentResult, int stage) {
        if (bridgeAnswer.get(stage).equals("U")) {
            currentResult = printMapUpsideWrong(currentResult, stage);
        }
        if (bridgeAnswer.get(stage).equals("D")) {
            currentResult = printMapDownsideWrong(currentResult, stage);
        }
        return currentResult;
    }

    public List<String> printMapUpsideCorrect(List<String> currentResult, int stage) {
        String correct = "[ O ]";
        String notSelected = "[   ]";
        currentResult.add(stage, notSelected);
        currentResult.add(0, correct);

        return currentResult;
    }

    public List<String> printMapDownsideCorrect(List<String> currentResult, int stage) {
        String correct = "[ O ]";
        String notSelected = "[   ]";

        currentResult.add(currentResult.size() - stage, notSelected);
        currentResult.add(correct);
        return currentResult;
    }

    public List<String> printMapUpsideWrong(List<String> currentResult, int stage) {
        String wrong = "[ X ]";
        String notSelected = "[   ]";
        currentResult.add(stage, notSelected);
        currentResult.add(0, wrong);

        return currentResult;
    }

    public List<String> printMapDownsideWrong(List<String> currentResult, int stage) {
        String wrong = "[ X ]";
        String notSelected = "[   ]";

        currentResult.add(currentResult.size() - stage, notSelected);
        currentResult.add(wrong);
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
