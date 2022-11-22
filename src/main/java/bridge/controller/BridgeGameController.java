package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.*;
import static bridge.view.InputView.*;

public class BridgeGameController {
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    static List<String> bridges = new ArrayList<>();
    static ArrayList<String> inputMove = new ArrayList<>();
    static ArrayList<Integer> input = new ArrayList<>();

    static int startCount = 1;
    static int check = 0;


    public void bridgeGame(){
        int bridgeLen = readBridgeSize();
        System.out.println("len:" + bridgeLen);

        bridges = bridgeMaker.makeBridge(bridgeLen);

        for(int count = 0; count < bridgeLen; count++){
            String move = readMoving();
            moveCheck(move);
            inputMove.add(move);
            try {
                resultFinal = moveResult(bridgeLen, count, move, bridges, inputMove, startCount);

            }catch (IllegalArgumentException e) {
                System.out.println(e);
            }

            if(resultFinal.size() != 0 && Integer.parseInt(resultFinal.get(0)) == bridgeLen+1){
                check++;
                break;
            }
        }
        //System.out.println("check" + check);
        //System.out.println("result: " + resultFinal.toString());

        if(check == 0){
            gameResult(resultFinal, bridgeLen, bridges, startCount);
        }

    }
    public List<String> setBridgeBySize(int size) {
        bridges = bridgeMaker.makeBridge(size);
        return bridges;
    }



}
