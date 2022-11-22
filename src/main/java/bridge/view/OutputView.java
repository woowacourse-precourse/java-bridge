package bridge.view;

import bridge.constant.Bridge;
import bridge.constant.Moving;
import bridge.constant.OutputMessage;
import bridge.domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        String upBridge = makeUpBridge(player);
        String downBridge = makeDownBridge(player);
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private String makeUpBridge(Player player) {
        List<String> upBridge = new ArrayList<>();
        for (int i = 0; i < player.getBridgeRoute().size(); i++) {
            if (player.getBridgeRoute().get(i).equals(Moving.UP)) {
                upBridge.add(player.getBridgeMap().get(i));
                continue;
            }
            upBridge.add(Bridge.EMPTY);
        }
        return Bridge.OPEN + String.join(Bridge.SPLIT, upBridge) + Bridge.CLOSE;
    }

    private String makeDownBridge(Player player) {
        List<String> downBridge = new ArrayList<>();
        for (int i = 0; i < player.getBridgeRoute().size(); i++) {
            if (player.getBridgeRoute().get(i).equals(Moving.DOWN)) {
                downBridge.add(player.getBridgeMap().get(i));
                continue;
            }
            downBridge.add(Bridge.EMPTY);
        }
        return Bridge.OPEN + String.join(Bridge.SPLIT, downBridge) + Bridge.CLOSE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player) {
        boolean success = player.getCorrectAnswerCount() == player.getBridgeRoute().size();
        String winLose = findWinLose(success);
        System.out.println(OutputMessage.GAME_RESULT_TEXT);
        printMap(player);
        System.out.println(OutputMessage.GAME_WIN_LOSE_TEXT + winLose);
        System.out.println(OutputMessage.TOTAL_TRY_COUNT_TEXT + player.getTryCount());
    }

    private String findWinLose(boolean success) {
        if (success) {
            return OutputMessage.SUCCESS;
        }
        return OutputMessage.FAIL;
    }

    public void printStart() {
        System.out.println(OutputMessage.START_TEXT);
    }
}
