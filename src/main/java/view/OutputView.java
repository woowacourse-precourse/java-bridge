package view;

import java.util.HashMap;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printRunGameText() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public static void printMap(String[][] userMap) {
        for (int row = 1; row >= 0; row--) {
            System.out.print("[ ");
            for (int column = 0; column < userMap[0].length-1; column++) {
                System.out.print(String.format("%s | ", userMap[row][column]));
            }
            System.out.println(String.format("%s ]", userMap[row][userMap[0].length-1]));
        }
        System.out.println("");
    }


    public static void printResultText() {
        System.out.println("최종 게임 결과");
    }

    public static void printResult(int result, int countOfAttempt) {
        Map<Integer, String> resultTable = Map.of(
                1, "성공",
                -1, "실패"
        );

        System.out.println(String.format("게임 성공 여부: %s", resultTable.get(result)));
        System.out.print(String.format("총 시도한 횟수: %,d", countOfAttempt));
    }
}
