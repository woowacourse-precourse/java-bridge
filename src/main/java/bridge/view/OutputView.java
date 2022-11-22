package bridge.view;

import bridge.constant.Game;
import bridge.constant.IOMessage;
import bridge.model.CrossingStatus;

import java.util.List;

public class OutputView {
    CrossingStatus bridgeStatus = new CrossingStatus();
    public void printStart() {
        System.out.println(IOMessage.START_GAME);
        System.out.println();
    }
    public void printMap(List<String> upBridge, List<String> downBridge) {
        printStatus(upBridge);
        printStatus(downBridge);
        System.out.println();
    }

    private void printStatus(List<String> bridgeStatus) {
        System.out.print(Game.BRIDGE_START);
        for(int i = 0; i < bridgeStatus.size(); i++) {
            System.out.print(bridgeStatus.get(i));
            if(i != bridgeStatus.size() -1) {
                System.out.print(Game.BRIDGE_BETWEEN);
            }
        }
        System.out.println(Game.BRIDGE_END);
    }
    public void printResult(boolean success, int gameCount) {
        System.out.println(IOMessage.GAME_RESULT);
        printMap(bridgeStatus.getUpBridgeStatus(), bridgeStatus.getDownBridgeStatus());
        System.out.print(IOMessage.GAME_SUCCESS);
        if(success) System.out.println(Game.GAME_SUCCESS);
        if(!success) System.out.println(Game.GAME_FAIL);
        System.out.println(IOMessage.TYR_COUNT + gameCount);
    }
}
