package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

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
        play();
    }

    private void printGameStartMsg(){
        inputView.getBridgeGameStartMsg();
        inputView.getInputBridgeLengthMsg();
    }

    private Bridge makeBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void play(){
        List<Integer> result = move(0, 0);
        int flag = result.get(0);
        int step = result.get(1);
        quit(flag, step);
        retry(flag);
    }

    private List<Integer> move(int flag, int step){
        while(step != bridgeGame.getBridgeSize()){
            boolean isEqual = settingMoving(step);
            if (!isEqual){
                flag = compareBridgeAndUserThink();
                break;
            }
            step++;
        }
        return List.of(flag, step);
    }

    private boolean settingMoving(int step){
        inputView.getInputMoveUpOrDownMsg();
        bridgeGame.setUserMoving(inputView.readMoving());
        boolean isEqual = bridgeGame.move(step);
        outputView.printMap(bridgeGame);
        return isEqual;
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
            play();
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
