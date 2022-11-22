package bridge;

import java.util.List;

/**
 * InputView / OutputView 사용 금지
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    String correct = " O ";
    String notSelected = "   ";
    String wrong = " X ";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String nextStep, List<String> bridgeAnswer, int round) {
        if (nextStep.equals(bridgeAnswer.get(round))) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryAnswer) {
        if (retryAnswer.equals("R")) {
            return true;
        }
        if (retryAnswer.equals("Q")) {
            return false;
        }
        return false;
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

        currentResult.add(notSelected);
        currentResult.add(stage, correct);

        return currentResult;
    }

    public List<String> printMapDownsideCorrect(List<String> currentResult, int stage) {
        currentResult.add(currentResult.size() - stage, notSelected);
        currentResult.add(correct);
        return currentResult;
    }

    public List<String> printMapUpsideWrong(List<String> currentResult, int stage) {
        currentResult.add(wrong);
        currentResult.add(stage, notSelected);

        return currentResult;
    }

    public List<String> printMapDownsideWrong(List<String> currentResult, int stage) {
        currentResult.add(currentResult.size() - stage, wrong);
        currentResult.add(notSelected);
        return currentResult;
    }


}
