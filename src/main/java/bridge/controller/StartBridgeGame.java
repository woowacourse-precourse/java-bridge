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

    public void run(){
        printStartGame();
        makeBridge(inputView.readBridgeSize());
        moveBridge();
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
            outputView.printInputMoveDirectionNotice();
            String direction = inputView.readMoving();
            String possibility = bridgeGame.move(bridge.get(i),direction);
            checkDirection(direction,possibility);
            outputView.printMap(checkUpCross,checkDownCross);
        }
    }

    private void initCheckCross(){
        checkUpCross = new LinkedList<>();
        checkDownCross = new LinkedList<>();
    }

    private void checkDirection(String direction, String possibility){
        if(direction.equals("U")){
            checkUpCross.add(possibility);
            checkDownCross.add(" ");
            return;
        }
        checkUpCross.add(" ");
        checkDownCross.add(possibility);
    }
}
