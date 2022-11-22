package bridge.view;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;

import java.util.List;
import java.util.stream.Collectors;

import bridge.constant.Direction;
import bridge.dto.TrialResult;

public class OutputView {
    public void printMap(List<TrialResult> trialResults) {
        printRow(getRow(UPPER, trialResults));
        printRow(getRow(LOWER, trialResults));
        System.out.println();
    }

    private List<String> getRow(Direction row, List<TrialResult> trialResults) {
        return trialResults.stream()
                .map(trialResult -> getDeck(row, trialResult))
                .collect(Collectors.toList());
    }

    private String getDeck(Direction row, TrialResult trialResult) {
        if (row != trialResult.getDirection()) {
            return " ";
        }
        if (trialResult.wasSuccessful()) {
            return "O";
        }
        return "X";
    }

    private void printRow(List<String> row) {
        System.out.print("[ ");
        System.out.print(String.join(" | ", row));
        System.out.println(" ]");
    }

    public void printResult(List<TrialResult> trialResults, int trialCount, boolean finished) {
        System.out.println("최종 게임 결과");
        printMap(trialResults);
        printFinished(finished);
        printTrialCount(trialCount);
        System.out.println();
    }

    private void printFinished(boolean finished) {
        if (finished) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (!finished) {
            System.out.println("게임 성공 여부: 실패");
        }
    }

    private void printTrialCount(int trialCount) {
        System.out.printf("총 시도한 횟수: %d", trialCount);
    }

    public void printException(String message) {
        System.out.println("[ERROR] " + message);
    }
}
