package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeUpDownNumber;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.common.BridgeGameConstants.NO;
import static bridge.common.BridgeGameConstants.YES;
import static bridge.common.BridgeGameConstants.SUCCESS;
import static bridge.common.BridgeGameConstants.FAILED;
import static bridge.exception.BridgeGameValidator.validateInt;
import static bridge.exception.BridgeGameValidator.isValidGameNumber;
import static bridge.exception.BridgeGameValidator.validateUpAndDown;
import static bridge.exception.BridgeGameValidator.validateRestartAndQuit;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeUpDownNumber bridgeUpDownNumber = new BridgeUpDownNumber();
    private int bridgeSize;
    private String moving;
    private String userRestart;
    List<String> bridge;

    public static BridgeGameController create(){
        return new BridgeGameController();
    }

    public void start(){
        bridgeSize=0;
        moving = null;
        startGame();
        run();
    }

    private void startGame(){
        outputView.printStart();
        createBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void run(){
        outputView.initBridgeState();
        boolean go = true;
        for (int index = 0;index<bridgeSize && go;index++) go = crossBridge(index);
        retryOrEnd(go);
    }

    private void retryOrEnd(boolean go){
        if (!go){
            restartGame();
        }
        if (go) {
            outputView.printResult(SUCCESS);
        }
    }

    private void restartGame(){
        restartOrQuit();
        boolean restart = bridgeGame.retry(userRestart);
        if(restart){
            run();
        }
        if(!restart){
            outputView.printResult(FAILED);
        }
    }

    private boolean crossBridge(int index){
        goUpOrDown();
        if(bridgeGame.move(moving,bridge.get(index))){
            outputView.printMap(YES, bridgeUpDownNumber.upOrDown(bridge.get(index)));
            return true;
        }
        outputView.printMap(NO, (bridgeUpDownNumber.upOrDown(bridge.get(index))+1)%2);
        return false;
    }

    private void goUpOrDown(){
        try{
            moving = validateUpAndDown(inputView.readMoving());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            goUpOrDown();
        }
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

    private void restartOrQuit(){
        try{
            userRestart = validateRestartAndQuit(inputView.readGameCommand());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            restartOrQuit();
        }
    }
}
