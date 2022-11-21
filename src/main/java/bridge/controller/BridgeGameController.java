package bridge.controller;

import bridge.model.BridgeGame;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.*;
import static bridge.model.BridgeMaker.makeBridge;
import static bridge.view.InputView.*;

public class BridgeGameController {
    public static void bridgeGame(){
        ArrayList<String> bridges = new ArrayList<>();
        ArrayList<String> inputMove = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        int startCount = 1;
        int check = 0;
        int bridgeLen = 0;

        bridgeLen = readBridgeSize();

        bridgeLenRangeCheck(bridgeLen);
        bridges = makeBridge(bridgeLen);

        for(int count = 0; count < bridgeLen; count++){
            String move = readMoving();
            moveCheck(move);
            inputMove.add(move);
            resultFinal = moveResult(bridgeLen, count, move, bridges, inputMove, startCount);
            //System.out.println("result: " +resultFinal);


            if(resultFinal.size() != 0 && Integer.parseInt(resultFinal.get(0)) == bridgeLen+1){
                //System.out.println("여기");
                check++;
                break;
            }
        }

        if(check == 0){
            gameResult(resultFinal, bridgeLen, bridges, startCount);
        }

    }
}
