package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.map.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, int index, String moving) {

        for (int i = 0; i < 2; i++) {
            System.out.print(Map.BRIDGE_START.getMark());
            for (int j = 0; j < index - 1; j++) {
                printRow();
                System.out.print(Map.BLOCK_SECTION.getMark());
            }
            printLast();
            System.out.println(Map.BRIDGE_END.getMark());
        }
        System.out.println();
    }

    private void printLast() {
    }

    public void printRow() {

    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player) {
        // TODO: Enum으로 리팩토링, 함수 리팩토링
        String gameClearResult = "";
        if (player.isGameClear()) {
            gameClearResult = "성공";
        }
        if (!player.isGameClear()) {
            gameClearResult = "실패";
        }
        System.out.println("게임 성공 여부: " + gameClearResult);
        System.out.println("총 시도한 횟수: " + player.getGameCount());
    }
}
