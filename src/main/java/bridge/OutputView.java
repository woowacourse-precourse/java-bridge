package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param moveResult
     */
    public void printMap(MoveResult moveResult) {
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        MoveStatus moveStatus = moveResult.getMoveStatus();
        List<String> history = moveResult.getHistory();

        if (moveStatus == MoveStatus.CORRECT || moveStatus == MoveStatus.CONTINUE) {
            for (String h : history) {
                char c = h.charAt(0);
                if (c == 'U') {
                    upper.add('O');
                    lower.add(' ');
                }

                if (c == 'D') {
                    upper.add(' ');
                    lower.add('O');
                }
            }
        }

        if (moveStatus == MoveStatus.FAIL) {
            for (int i = 0; i < history.size() - 1; i++) {
                char c = history.get(i).charAt(0);
                if (c == 'U') {
                    upper.add('O');
                    lower.add(' ');
                }

                if (c == 'D') {
                    upper.add(' ');
                    lower.add('O');
                }
            }

            char lastChar = history.get(history.size() - 1).charAt(0);
            if (lastChar == 'U') {
                upper.add('X');
                lower.add(' ');
            }

            if (lastChar == 'D') {
                upper.add(' ');
                lower.add('X');
            }

        }


        System.out.print("[");
        for (int i = 0; i < upper.size() - 1; i++) {
            System.out.print(" " + upper.get(i) + " |");
        }
        System.out.print(" " + upper.get(upper.size() - 1) + " ");
        System.out.print("]");

        System.out.println();

        System.out.print("[");
        for (int i = 0; i < lower.size() - 1; i++) {
            System.out.print(" " + lower.get(i) + " |");
        }
        System.out.print(" " + lower.get(lower.size() - 1) + " ");
        System.out.print("]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MoveResult moveResult, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(moveResult);
        System.out.println();

        System.out.println("게임 성공 여부: " + moveResult.getMoveStatus());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTotalAttempt());


    }
}
