package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static bridge.model.BridgeGame.*;
import static bridge.model.BridgeMaker.makeBridge;
import static bridge.view.InputView.*;

public class BridgeGameController {
    static ArrayList<String> bridges = new ArrayList<>();
    static ArrayList<String> inputMove = new ArrayList<>();
    static ArrayList<Integer> input = new ArrayList<>();

    static int startCount = 1;
    static int check = 0;


    public void bridgeGame(){
        int bridgeLen = readBridgeSize();

        //bridgeLenRangeCheck(bridgeLen);

        bridges =  makeBridge(bridgeLen);

        for(int count = 0; count < bridgeLen; count++){
            String move = readMoving();
            moveCheck(move);
            inputMove.add(move);
            try {
                resultFinal = moveResult(bridgeLen, count, move, bridges, inputMove, startCount);

            }catch (IllegalArgumentException e) {
                System.out.println(e);
            }finally {
                System.out.println("오류");
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

}
