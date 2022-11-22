package bridge.view;

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
    public void printMap(List<String> inputResults, int index, String moveAnswer) {
        System.out.print("[ ");
        for (int i = 0; i <= index; i++) {
            if (moveAnswer.equals("U")) {
                System.out.print(inputResults.get(i));
            } else {
                System.out.print(" ");
            }

            if (i < index) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");

        System.out.print("[ ");
        for (int i = 0; i <= index; i++) {
            if (moveAnswer.equals("D")) {
                System.out.print(inputResults.get(i));
            } else {
                System.out.print(" ");
            }

            if (i < index) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isWinning) {
        System.out.print("게임 성공 여부: ");  //프린트
        if (isWinning) {
            System.out.println("성공");
            return;
        }

        System.out.println("실패");
    }

    public void printCountResult(int count) {
        System.out.println("총 시도한 횟수: " + count);
    }
}
