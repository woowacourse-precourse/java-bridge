package bridge.view;

import bridge.model.Result;
import java.util.List;

public class OutputView {

    public void printMap(List<Result> gameResults) {
        upperMap(gameResults);
        downMap(gameResults);
        System.out.println();
    }

    private void upperMap(List<Result> gameResults) {
        System.out.print("[ ");

        for (int i = 0; i < gameResults.size() - 1; i++) {
            System.out.print(gameResults.get(i).getUpper());
            System.out.print(" | ");
        }

        System.out.print(gameResults.get(gameResults.size() - 1).getUpper());
        System.out.println(" ]");
    }

    private void downMap(List<Result> gameResults) {
        System.out.print("[ ");

        for (int i = 0; i < gameResults.size() - 1; i++) {
            System.out.print(gameResults.get(i).getDown());
            System.out.print(" | ");
        }

        System.out.print(gameResults.get(gameResults.size() - 1).getDown());
        System.out.println(" ]");
    }

    public void printResult(List<Result> gameResults, boolean isSuccess, int retryCount) {
        System.out.println("최종 게임 결과");
        printMap(gameResults);
        System.out.println("게임 성공 여부: " + getGameEndText(isSuccess));
        System.out.println("총 시도한 횟수: " + retryCount);
    }

    private String getGameEndText(boolean isSuccess) {
        if (!isSuccess) {
            return "실패";
        }
        return "성공";
    }
}
