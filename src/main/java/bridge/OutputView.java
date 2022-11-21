package bridge;


import bridge.domain.MoveResults;

public class OutputView {
    private static final String RESULT_GREETING = "최종 게임 결과";
    private static final String RESULT = "게임 성공여부: ";

    public void printMap(MoveResults moveResults) {
        moveResults.getMoveResults().stream()
                .map(moveResult -> CrossResult.successFailureLetter(moveResult.isMatchResult()))
                .forEach(System.out::println);
    }

    public static void printEachMap(MoveResults moveResults) {
        moveResults.getMoveResults().stream()
                .map(moveResult -> CrossResult.successFailureLetter(moveResult.isMatchResult()))
                .forEach(System.out::println);
    }

    public void resultGreeting() {
        System.out.println(RESULT_GREETING);
    }

    public void printResult(MoveResults moveResults) {
        printMap(moveResults);
        System.out.println(RESULT + CrossResult.successFailureWord(moveResults.success()));
    }
}
