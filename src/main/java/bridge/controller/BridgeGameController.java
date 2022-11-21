package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private boolean isRunning;
    private int count;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            bridgeGame.setBridges(bridgeMaker.makeBridge(bridgeSize));
            gameStart();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void gameStart() {
        int index = 0;
        isRunning = true;
        count = 1;
        boolean isSuccess = true;
        while(index != bridgeGame.getBridgeSize()){
            isSuccess = bridgeGame.move(bridgeGame.getBridges().get(index), inputView.readMoving());
            outputView.printMap(bridgeGame.getBridges(), index++, isSuccess);
            if(!isSuccess){ // 움직이는데 실패
                index = getIndex(index);
            }
            if(!isRunning) break;
        }
        outputView.printResult(bridgeGame.getBridges(), index, isRunning);
        outputView.printTotalAttemptsMade(count);
    }

    private int getIndex(int index) {
        boolean isRetry = bridgeGame.isRetry(inputView.readGameCommand());
        if(isRetry){
            index = 0;
            count++;
        }
        if(!isRetry){
            isRunning = false;
        }
        return index;
    }
}
