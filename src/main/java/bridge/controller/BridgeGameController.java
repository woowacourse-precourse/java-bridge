package bridge.controller;

import bridge.model.BridgeGame;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.*;
import static bridge.model.BridgeMaker.makeBridge;
import static bridge.view.InputView.*;

public class BridgeGameController {
    static ArrayList<String> bridges = new ArrayList<>();
    static ArrayList<String> inputMove = new ArrayList<>();
    static ArrayList<Integer> input = new ArrayList<>();

    static int startCount = 1;
    static int check = 0;

    public static void bridgeGame(){

        int bridgeLen = 0;

        bridgeLen = readBridgeSize();

        bridgeLenRangeCheck(bridgeLen);
        bridges = makeBridge(bridgeLen);

        repeat(bridgeLen);

        if(check == 0){
            gameResult(resultFinal, bridgeLen, bridges, startCount);
        }

    }

    public static void repeat(int bridgeLen){
        for(int count = 0; count < bridgeLen; count++){
            String move = readMoving();
            moveCheck(move);
            inputMove.add(move);
            resultFinal = moveResult(bridgeLen, count, move, bridges, inputMove, startCount);

            if(resultFinal.size() != 0 && Integer.parseInt(resultFinal.get(0)) == bridgeLen+1){
                check++;
                break;
            }
        }
    }
}
