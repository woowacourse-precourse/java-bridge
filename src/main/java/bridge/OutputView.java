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
    public void printMap(List<String> upBridge, List<String> downBridge, int currentSize) {
        int limit = currentSize + 1;
        bridgePrint(upBridge, limit);
        bridgePrint(downBridge, limit);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int gameCount, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        bridgePrint(bridgeGame.getUpBridge(), bridgeGame.getUpBridge().size());
        bridgePrint(bridgeGame.getDownBridge(), bridgeGame.getDownBridge().size());
        System.out.println();
        System.out.print("게임 성공 여부: ");
        printGameResult(result);
        System.out.println("총 시도한 횟수: " + gameCount);
    }

    private void bridgePrint(List<String> bridge, int limit) {
        System.out.print("[ ");
        for (int i = 0; i < limit; i++) {
            if (i != 0) {
                System.out.print(" | ");
            }
            System.out.print(bridge.get(i));
        }
        System.out.println(" ]");
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    private void printGameResult(String result) {
        if (result.equals("O")) {
            System.out.println("성공");
        } else if (result.equals("X")) {
            System.out.println("실패");
        }
    }

}
