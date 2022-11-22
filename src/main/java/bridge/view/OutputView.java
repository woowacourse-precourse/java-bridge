package bridge.view;

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
     */
    public void printMap(List<String> upResults, List<String> downResults, int index) {
        System.out.print("[ ");
        for (int i = 0; i <= index; i++) {
            System.out.print(upResults.get(i));
            if (i < index) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");

        System.out.print("[ ");
        for (int i = 0; i <= index; i++) {
            System.out.print(downResults.get(i));
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
    public void printResult(boolean isWinning, int count, int bridgeSize) {
        String message = "게임 성공 여부: ";
        if (isWinning) {
            message += "성공\n";
        } else {
            message += "실패\n";
        }

        message += "총 시도한 횟수: " + count;

        System.out.print(message);
    }
}
