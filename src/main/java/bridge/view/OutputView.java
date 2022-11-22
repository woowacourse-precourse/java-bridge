package bridge.view;

import bridge.Enum.GameOutput;
import bridge.Enum.Message;
import bridge.domain.BridgeGame;

import java.util.List;

public class OutputView {
    BridgeGame bridgeGame = new BridgeGame();

    public void printStart(){
        System.out.println(Message.START_GAME.getValue());
    }

    public void printMap(List<String> upBridge, List<String> downBridge) {
        printStatus(upBridge);
        printStatus(downBridge);
        System.out.println();
    }

    public void printStatus(List<String> blocks){
        System.out.print(GameOutput.BRIDGE_START.getMessage());
        for (int i = 0; i < blocks.size()-1; i++) {
            System.out.print(blocks.get(i));
            System.out.print(GameOutput.BAR.getMessage());
        }
        System.out.print(blocks.get(blocks.size()-1));
        System.out.println(GameOutput.BRIDGE_END.getMessage());
    }

    public void printResult(boolean success, int tryCount) {
        System.out.println(Message.TOTAL_RESULT.getValue());
        printMap(bridgeGame.getUpBlocks(), bridgeGame.getDownBlocks());
        System.out.println(Message.SUCCESS_RESULT.getValue() + returnSuccess(success));
        System.out.println(Message.TRY_COUNT.getValue() + tryCount);
    }

    public String returnSuccess(boolean success){
        if(success) return Message.SUCCESS.getValue();
        return Message.FAIL.getValue();
    }
}
