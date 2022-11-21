package bridge.view;

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
            if (player.getBridgeRoute().get(i).equals("U")) {
                upBridge.add(player.getBridgeMap().get(i));
                continue;
            }
            upBridge.add(" ");
        }
        return "[ " + String.join(" | ", upBridge) + " ]";
    }

    private String makeDownBridge(Player player) {
        List<String> downBridge = new ArrayList<>();
        for (int i = 0; i < player.getBridgeRoute().size(); i++) {
            if (player.getBridgeRoute().get(i).equals("D")) {
                downBridge.add(player.getBridgeMap().get(i));
                continue;
            }
            downBridge.add(" ");
        }
        return "[ " + String.join(" | ", downBridge) + " ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player) {
        boolean success = player.getCorrectAnswerCount() == player.getBridgeRoute().size();
        String winLose = findWinLose(success);
        System.out.println("최종 게임 결과");
        printMap(player);
        System.out.println("게임 성공 여부: " + winLose);
        System.out.println("총 시도한 횟수: " + player.getTryCount());
    }

    private String findWinLose(boolean success) {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
