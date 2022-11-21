package bridge;

import java.util.Arrays;
import java.util.Iterator;
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

    public OutputView() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public void printMap(List<List<String>> userBridge) {
        List<Integer> limit = Arrays.asList(BridgeGame.UPWARD, BridgeGame.DOWNWARD);
        for (Integer direction : limit) {
            printWard(userBridge.get(direction).iterator());
        }
        System.out.println();
    }

    private void printWard(Iterator<String> ward) {
        System.out.print("[");
        while (ward.hasNext()) {
            String next = ward.next();
            System.out.print(" " + next + " ");
            if (ward.hasNext()) {
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getUserInputBridge());
        System.out.println("게임 성공 여부: " + getResult(bridgeGame));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    private String getResult(BridgeGame bridgeGame) {
        if (bridgeGame.getUserInputBridge().get(0).size() == Application.bridgeSize) {
            return "성공";
        }
        return "실패";
    }
}
