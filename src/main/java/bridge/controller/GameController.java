package bridge.controller;

import bridge.constant.Constant;
import bridge.model.BridgeGame;
import bridge.model.Move;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    static String result = Constant.SUCCESS;

    public void start(){
        outputView.startPrint();
        int size = inputView.readBridgeSize();
        bridgeGame.initialize(size);

    }
    public void progress(){
        boolean retry = true;
        int i=0;
        while(retry && i<bridgeGame.getSize()){
            if(!play(i)) { //실패시 재시작 이면 초기화, 종료면 while 탈출
                retry = bridgeGame.retry(inputView.readGameCommand());
                i=-1;
            }
            i++; }
        if(!retry)result = Constant.FAIL;
        outputView.printResult(bridgeGame.getTryCnt(), result, bridgeGame.getUserMap());
    }

    public boolean play(int idx){

        Move move = bridgeGame.moveConstructor(inputView.readMoving());
        boolean success = bridgeGame.move(idx, move);
        List<List<String>> userMap =  bridgeGame.getUserMap();
        if(success){
            outputView.printMap(idx+1, userMap.get(0), userMap.get(1));
            return true;
        }
        outputView.printMap(idx+1, userMap.get(0), userMap.get(1));
        return false;
    }

}
