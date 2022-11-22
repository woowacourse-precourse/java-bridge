package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class StartBridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static List<String> bridge;
    private static List<String> checkUpCross;
    private static List<String> checkDownCross;
    private static String direction;
    private static String possibility;
    private static boolean reStart = true;
    private static int tryCount = 0;
    private static String successOrFailure;

    public void run(){
        printStartGame();
        makeBridge(inputView.readBridgeSize());
        while(reStart){
            tryCount++;
            moveBridge();
            if(reStart){
                checkReStartGame();
            }
        }
        getPrintResult();
    }

    private void printStartGame(){
        outputView.printStartGameNotice();
        outputView.printInputBridgeSizeNotice();
    }

    private void makeBridge(int size){
        bridge = bridgeMaker.makeBridge(size);
        outputView.printNewLine();
    }

    private void moveBridge(){
        initCheckCross();
        for(int i=0;i<bridge.size();i++){
            setDirectionAndPossibility(i);
            getPrintMap();
            if(checkPossibility(possibility)){
                return;
            }
        }
        successOrFailure = "성공";
        reStart = false;
    }

    private void initCheckCross(){
        checkUpCross = new LinkedList<>();
        checkDownCross = new LinkedList<>();
    }

    private void setDirectionAndPossibility(int index){
        outputView.printInputMoveDirectionNotice();
        direction = inputView.readMoving();
        possibility = bridgeGame.move(bridge.get(index),direction);
    }

    private void getPrintMap(){
        setUpDownCross(direction,possibility);
        outputView.printMap(checkUpCross,checkDownCross);
    }

    private void setUpDownCross(String direction, String possibility){
        if(direction.equals("U")){
            checkUpCross.add(possibility);
            checkDownCross.add(" ");
            return;
        }
        checkUpCross.add(" ");
        checkDownCross.add(possibility);
    }

    private boolean checkPossibility(String possibility){
        if(possibility.equals("X")){
            successOrFailure = "실패";
            return true;
        }
        return false;
    }

    private void checkReStartGame(){
        outputView.printReStartGameNotice();
        String gameCommand = inputView.readGameCommand();
        reStart = bridgeGame.retry(gameCommand);
    }

    private void getPrintResult(){
        outputView.printResult(tryCount, successOrFailure);
    }
}
