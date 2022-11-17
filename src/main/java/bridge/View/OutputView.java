package bridge.View;

import bridge.Domain.BridgeGame;
import bridge.Domain.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String printSelectedStair(Player player, String stair) {
        if (!stair.equals(player.getLastSelection())) {
            return "   ";
        }

        if (!player.isAlive()) {
            return " X ";
        }

        return " O ";
    }

    private String printPassedStair(List<String> bridgeStates, int passedCount, String stair) {
        String result = "";

        for (int bridgeLocation = 0; bridgeLocation < passedCount; bridgeLocation++) {
            String state = "   ";
            if (stair.equals(bridgeStates.get(bridgeLocation))) {
                state = " O ";
            }
            state += "|";
            result += state;
        }

        return result;
    }

    private void printStair(List<String> bridgeStates, Player player, String stair) {
        String result = "[";
        result += printPassedStair(bridgeStates, player.getNextLocation(), stair);
        result += printSelectedStair(player, stair);
        result += "]";

        System.out.println(result);
    }

    public void printMap(BridgeGame bridgeGame) {
        List<String> bridgeState = bridgeGame.getBridgeStates();
        Player player = bridgeGame.getPlayer();

        printStair(bridgeState, player, "U");
        printStair(bridgeState, player, "D");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private String printIsSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerDead()) {
            return "실패";
        }

        return "성공";
    }
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);

        System.out.println("게임 성공 여부: " + printIsSuccess(bridgeGame));
        System.out.println("총 시도한 횟수: " + bridgeGame.getRetryCount());
    }
}
