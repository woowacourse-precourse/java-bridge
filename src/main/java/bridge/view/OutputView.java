package bridge.view;

import static bridge.constant.Deck.BLANK;
import static bridge.constant.Deck.MATCH;
import static bridge.constant.Deck.WRONG;
import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;

import java.util.List;
import java.util.stream.Collectors;

import bridge.constant.Deck;
import bridge.constant.Direction;
import bridge.dto.TrialResult;

public class OutputView {

    private static final String ROW_BEGIN = "[ ";
    private static final String ROW_END = " ]";
    private static final String DECK_SEPARATOR = " | ";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public void printMap(List<TrialResult> trialResults) {
        printRow(getRow(UPPER, trialResults));
        printRow(getRow(LOWER, trialResults));
        System.out.println();
    }

    private List<Deck> getRow(Direction row, List<TrialResult> trialResults) {
        return trialResults.stream()
                .map(trialResult -> getDeck(row, trialResult))
                .collect(Collectors.toUnmodifiableList());
    }

    private Deck getDeck(Direction row, TrialResult trialResult) {
        if (row != trialResult.getDirection()) {
            return BLANK;
        }
        if (trialResult.wasSuccessful()) {
            return MATCH;
        }
        return WRONG;
    }

    private void printRow(List<Deck> row) {
        System.out.print(ROW_BEGIN);
        System.out.print(joinDecksForDisplay(row));
        System.out.println(ROW_END);
    }

    private String joinDecksForDisplay(List<Deck> row) {
        return row.stream()
                .map(Deck::getDisplayCharacter)
                .collect(Collectors.joining(DECK_SEPARATOR));
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
        System.out.println(EXCEPTION_PREFIX + message);
    }
}
