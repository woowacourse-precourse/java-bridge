package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private int userTry;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.userTry = 1;
    }

    public void run(){
        printGameStartMsg();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        move();
    }

    private void printGameStartMsg(){
        inputView.getBridgeGameStartMsg();
        inputView.getInputBridgeLengthMsg();
    }

    private Bridge makeBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void move(){
        int flag = 0;
        int step = 0;
        while(step != bridgeGame.getBridgeSize()){
            inputView.getInputMoveUpOrDownMsg();
            bridgeGame.setUserMoving(inputView.readMoving());
            boolean isEqual = bridgeGame.move(step);
            outputView.printMap(bridgeGame);
            if (!isEqual){
                flag = compareBridgeAndUserThink();
                break;
            }
            step++;
        }

        quit(flag, step);
        retry(flag);
    }

    private int compareBridgeAndUserThink(){
        int flag = 0; // -1: quit, 0: nothing, 1: retry
        inputView.getInputRestartOrQuitMsg();
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            flag = -1;
        }
        if (gameCommand.equals("R")){
            flag = 1;
        }
        return flag;
    }

    private void quit(int flag, int step){
        if (flag == -1 || step == bridgeGame.getBridgeSize()){
            printResult(flag);
        }
    }

    private void retry(int flag){
        if (flag == 1){
            bridgeGame.retry();
            userTry++;
            move();
        }
    }

    private void printResult(int quitFlag){
        if (quitFlag == -1){
            outputView.printResult(bridgeGame, true, userTry);
            return;
        }
        outputView.printResult(bridgeGame, false, userTry);
    }
}
