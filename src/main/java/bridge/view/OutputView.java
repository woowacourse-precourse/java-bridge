package bridge.view;

import java.util.List;
import java.util.stream.Collectors;

import bridge.constant.Direction;
import bridge.dto.TrialResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
