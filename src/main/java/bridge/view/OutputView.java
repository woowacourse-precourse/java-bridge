package bridge.view;

import bridge.Enum.GameOutput;
import bridge.Enum.Message;
import bridge.domain.BridgeGame;

import java.util.List;

public class OutputView {
    BridgeGame bridgeGame = new BridgeGame();

    public void printStart(){
        System.out.println(Message.START_GAME);
    }

    public void printMap(List<String> upBridge, List<String> downBridge) {
        printStatus(upBridge);
        printStatus(downBridge);
        System.out.println();
    }

    public void printStatus(List<String> blocks){
        System.out.print(GameOutput.BRIDGE_START);
        for (int i = 0; i < blocks.size()-1; i++) {
            System.out.print(blocks.get(i));
            System.out.print(GameOutput.BAR);
        }
        System.out.print(blocks.get(blocks.size()-1));
        System.out.println(GameOutput.BRIDGE_END);
    }

    public void printResult(boolean success, int tryCount) {
        System.out.println(Message.TOTAL_RESULT);
        printMap(bridgeGame.getUpBlocks(), bridgeGame.getDownBlocks());
        System.out.println(Message.SUCCESS_RESULT);
        System.out.println(returnSuccess(success));
        System.out.println(String.valueOf(Message.TRY_COUNT) + tryCount);
    }

    public String returnSuccess(boolean success){
        if(success) return String.valueOf(Message.SUCCESS);
        return String.valueOf(Message.FAIL);
    }
}
