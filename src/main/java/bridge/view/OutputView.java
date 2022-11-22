package bridge.view;

import bridge.service.BridgeService;

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
    public static void printMap(List<String>[] move) {
        for (int i = 0; i < move.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < move[i].size(); j++) {
                if (j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(move[i].get(j));
            }
            System.out.println(" ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String>[] move) {
        System.out.println("최종 게임 결과");
        printMap(move);
    }

    public static void printGameSuccess(boolean result) {
        if (result) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }

    public static void printTryCount() {
        System.out.println("총 시도한 횟수: " + BridgeService.getTryCount());
    }
}
