package bridge;

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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
