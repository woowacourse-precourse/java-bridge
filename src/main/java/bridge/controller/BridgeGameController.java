package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeUpDownNumber;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private int bridgeSize;
    List<String> bridge;
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeMaker bridgeMaker;
    private BridgeUpDownNumber bridgeUpDownNumber;

    public static BridgeGameController create(){
        return new BridgeGameController();
    }

    public void start(){
        startGame();
        run();
    }

    private void run(){
        outputView.initMap();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        IntStream.range(0,bridgeSize)
                .forEach(index -> crossBridge(index));
    }

    private void crossBridge(int index){
        if(bridgeGame.move(inputView.readMoving(),index,bridge)){
            outputView.printMap("O", bridgeUpDownNumber.upOrDown(bridge.get(index)));
        }
        if(!bridgeGame.move(inputView.readMoving(), index, bridge)){
            outputView.printMap("X", bridgeUpDownNumber.upOrDown(bridge.get(index)));
        }
    }

    private void startGame(){
        outputView.printStart();
        bridgeSize = inputView.readBridgeSize();
    }

    private void restartGame(){
        boolean restart = bridgeGame.retry(inputView.readGameCommand());
        if(restart){
            run();
        }
    }

}
