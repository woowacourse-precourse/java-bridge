package bridge.ui;

import bridge.domain.Bridge;
import bridge.domain.BridgeShapeMatcher;
import bridge.domain.Player;
import bridge.domain.SuccessFail;

import java.util.List;

public class OutputView {

    public void printMap(Player player) {

        List<BridgeShapeMatcher> playerBridge = player.getBridgeShapeMatcher();
        System.out.println(printUpFloor(playerBridge));
        System.out.println(printDownFloor(playerBridge));
        System.out.println();
    }

    public void printResult(Player player) {
        System.out.println("최종 게임 결과");
        printMap(player);
        SuccessFail successFail = SuccessFail.findSuccessFail(player.isSuccess());
        System.out.print("게임 성공 여부: " + successFail.getMessage()+"\n");
        System.out.println("총 시도한 횟수: "+player.getTryNumber());
    }

    public String printUpFloor(List<BridgeShapeMatcher> playerBridge){
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < playerBridge.size(); i++) {
            result.append(playerBridge.get(i).getUpFloor()).append(" | ");
        }
        result.replace(result.length()-2,result.length(),"]");
        return result.toString();
    }

    public String printDownFloor(List<BridgeShapeMatcher> playerBridge){
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < playerBridge.size(); i++) {
            result.append(playerBridge.get(i).getDownFloor()).append(" | ");
        }
        result.replace(result.length()-2,result.length(),"]");
        return result.toString();
    }


}
