package bridge.view;

import java.util.List;
import java.util.stream.Collectors;

import bridge.constant.Direction;
import bridge.dto.TrialResult;

public class OutputView {

    public void printMap(List<TrialResult> trialResults) {
        printAsDecks(Direction.UPPER, trialResults);
        printAsDecks(Direction.LOWER, trialResults);
    }

    private void printAsDecks(Direction deckDirection, List<TrialResult> trialResults) {
        String deck = trialResults.stream()
                .map(trialResult -> getDeck(deckDirection, trialResult))
                .collect(Collectors.joining(" | "));
        System.out.print("[ ");
        System.out.print(deck);
        System.out.println(" ]");
    }

    private String getDeck(Direction deckDirection, TrialResult trialResult) {
        if (deckDirection != trialResult.getDirection()) {
            return " ";
        }
        if (trialResult.wasSuccessful()) {
            return "O";
        }
        return "X";
    }

    public void printResult(List<TrialResult> trialResults, int trialCount, boolean finished) {
        System.out.println("최종 게임 결과");
        printMap(trialResults);
        System.out.println();
        if (finished) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (!finished) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.printf("총 시도한 횟수: %d" + System.lineSeparator(), trialCount);
    }

    public void printException(String message) {
        System.out.println("[ERROR] " + message);
    }
}
