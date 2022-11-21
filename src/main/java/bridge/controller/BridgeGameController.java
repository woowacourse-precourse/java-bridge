package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.moveResult;
import static bridge.model.BridgeMaker.makeBridge;
import static bridge.view.InputView.*;

public class BridgeGameController {
    public static void bridgeGame(){
        int bridgeLen = readBridgeSize();
        bridgeLenRangeCheck(bridgeLen);
        List<String> bridges = new ArrayList<>();
        bridges = makeBridge(bridgeLen);

        ArrayList<String> inputMove = new ArrayList<>();
        for(int count = 0; count < bridgeLen; count++){
            System.out.println("count" + count);
            String move = readMoving();
            inputMove.add(move);
            moveResult(count, move, bridges, inputMove);
        }
    }
}
