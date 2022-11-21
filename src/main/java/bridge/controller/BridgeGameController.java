package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridges;
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
            bridges = bridgeMaker.makeBridge(bridgeSize);
            bridgeGame.setBridges(bridges);
            gameStart();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void gameStart() {
        int index = 0;
        isRunning = true;
        System.out.println(bridgeGame.getBridges());
        count = 1;
        boolean isSuccess = true;
        while(index != bridges.size()){
            isSuccess = bridgeGame.move(bridges.get(index), inputView.readMoving());
            outputView.printMap(bridgeGame.getBridges(), index++, isSuccess);
            if(!isSuccess){ // 움직이는데 실패
                index = getIndex(index);
            }
            if(!isRunning) break;
        }
        outputView.printResult(bridgeGame.getBridges(), index, isRunning, count);
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
