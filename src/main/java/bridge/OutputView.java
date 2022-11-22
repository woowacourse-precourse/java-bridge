package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(List<Result> gameResults) {
        upperMap(gameResults);
        System.out.println();
        downMap(gameResults);
        System.out.println();
    }

    private void upperMap(List<Result> gameResults){
        System.out.print("[ ");

        for (int i = 0; i < gameResults.size() - 1; i++){
            System.out.print(gameResults.get(i).getUpper());
            System.out.print(" | ");
        }

        System.out.print(gameResults.get(gameResults.size() - 1).getUpper());
        System.out.print(" ]");
    }

    private void downMap(List<Result> gameResults){
        System.out.print("[ ");

        for (int i = 0; i < gameResults.size() - 1; i++){
            System.out.print(gameResults.get(i).getDown());
            System.out.print(" | ");
        }

        System.out.print(gameResults.get(gameResults.size() - 1).getDown());
        System.out.print(" ]");
    }

    public void printResult(List<Result> gameResults, boolean isSuccess, int retryCount) {
        String successText = "성공";
        if (!isSuccess){
            successText = "실패";
        }
        System.out.println("최종 게임 결과");
        printMap(gameResults);
        System.out.println("게임 성공 여부: "+successText);
        System.out.println("총 시도한 횟수: "+retryCount);
    }
}
