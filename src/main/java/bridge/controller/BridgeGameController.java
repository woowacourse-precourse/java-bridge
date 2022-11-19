package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeUpDownNumber;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.exception.BridgeGameValidator.*;

public class BridgeGameController {

    private static final String SUCCESS = "성공";
    private static final String FAILED = "실패";
    private static final String YES = "O";
    private static final String NO = "X";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private int bridgeSize;
    private String moving;
    List<String> bridge;
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeUpDownNumber bridgeUpDownNumber = new BridgeUpDownNumber();

    public static BridgeGameController create(){
        return new BridgeGameController();
    }

    public void start(){
        bridgeSize=0;
        moving = null;
        startGame();
        run();
    }

    private void run(){
        outputView.initMap();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        boolean go = true;
        for (int index = 0;index<bridgeSize && go;index++) {
            go = crossBridge(index);
        }
        retryOrEnd(go);
    }

    private boolean crossBridge(int index){
        goUpOrDown();
        if(bridgeGame.move(moving,index,bridge)){
            outputView.printMap(YES, bridgeUpDownNumber.upOrDown(bridge.get(index)));
            return true;
        }
        outputView.printMap(NO, (bridgeUpDownNumber.upOrDown(bridge.get(index))+1)%2);
        return false;
    }

    private void retryOrEnd(boolean go){
        if (!go){
            restartGame();
        }
        if (go) {
            outputView.printResult(SUCCESS);
        }
    }

    private void startGame(){
        outputView.printStart();
        createBridgeSize();
    }

    private void createBridgeSize(){
        try{
            bridgeSize = validateInt(inputView.readBridgeSize());
            isValidGameNumber(bridgeSize);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            createBridgeSize();
        }
    }

    private void goUpOrDown(){
        try{
            moving = validateUpAndDown(inputView.readMoving());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            goUpOrDown();
        }
    }

    private void restartGame(){
        boolean restart = bridgeGame.retry(inputView.readGameCommand());
        if(restart){
            run();
        }
        outputView.printResult(FAILED);
    }

}
