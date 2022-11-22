package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.*;
import static bridge.view.InputView.*;

public class BridgeGameController {
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static List<String> bridges = new ArrayList<>();
    static ArrayList<String> inputMove = new ArrayList<>();

    static int startCount = 1;
    static int check = 0;


    public void bridgeGame(){
        int bridgeLen = readBridgeSize();

        System.out.println(bridgeMaker);
        bridges = bridgeMaker.makeBridge(bridgeLen);

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
        if(check == 0){
            gameResult(resultFinal, bridgeLen, bridges, startCount);
        }

    }


}
