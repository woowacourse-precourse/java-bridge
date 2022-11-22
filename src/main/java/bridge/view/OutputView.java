package bridge.view;

import java.util.ArrayList;
import java.util.Collections;
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
    public void printMap(List<String> bridge, boolean gameResult) {
        String correctMove = bridge.get(bridge.size() - 1);
        bridge = bridge.subList(0, bridge.size() - 1);
        List<String> bridgeMap = this.maskLastMove(bridge, correctMove, gameResult);
        System.out.println(this.toString(this.uBridge(bridgeMap)));
        System.out.println(this.toString(this.dBridge(bridgeMap)));
    }


    // formats last step of bridge to reflect player's move
    public List<String> maskLastMove(List<String> bridge, String correctMove, boolean gameResult) {
        if (gameResult) {
            bridge.add(correctMove);
        } else if (correctMove.equals("U")) {
            bridge.add("0");
        } else if (correctMove.equals("D")) {
            bridge.add("1");
        }
        return bridge;
    }




    public List<String> uBridge(List<String> progressBridge) {
        List<String> uBridge = new ArrayList<>(progressBridge);
        Collections.replaceAll(uBridge, "D", " ");
        Collections.replaceAll(uBridge, "0", " ");
        Collections.replaceAll(uBridge, "U", "O");
        Collections.replaceAll(uBridge, "1", "X");
        return uBridge;
    }

    public List<String> dBridge(List<String> progressBridge) {
        List<String> dBridge = new ArrayList<>(progressBridge);
        Collections.replaceAll(dBridge, "U", " ");
        Collections.replaceAll(dBridge, "1", " ");
        Collections.replaceAll(dBridge, "D", "O");
        Collections.replaceAll(dBridge, "0", "X");
        return dBridge;
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, boolean gameResult, int gameCount) {
        System.out.println("최종 게임 결과");
        this.printMap(bridge, gameResult);
        String result = "실패";
        if (gameResult) {
            result = "성공";
        }
        System.out.println("\n게임 성공 여부: " + result + "\n총 시도한 횟수: " + gameCount);
    }





    public String toString(List<String> bridge) {
        return "[ " + String.join(" | ", bridge) + " ]";
    }
}
