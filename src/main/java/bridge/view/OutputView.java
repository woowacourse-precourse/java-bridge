package bridge.view;

import bridge.BridgeGame;
import bridge.Direction;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> userMap, int cur) {
        for (int i = 0; i < Direction.values().length; i++) { //TODO foreach로 enum 활용할 수 있게 수정(순서 주의)
            System.out.print("[");
            for (int j = 0; j < cur; j++) {
                System.out.printf(" %s |", userMap.get(j).get(i));
            }
            System.out.println("\b]");
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, List<List<String>> userMap) {
        System.out.println("최종 게임 결과");
        printMap(userMap, bridgeGame.getCur());
        System.out.print("게임 성공 여부: ");
        if (bridgeGame.isEnd()) {
            System.out.println("성공");
        }  //TODO isEnd()지만 실패인 경우 처리
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getTryCount());
    }
}
