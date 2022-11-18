package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.Service;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Service service = new Service();

    public void run(){
        startGame();
    }

    public void startGame(){
        outputView.printStartGame();
        BridgeNumberGenerator bridgeNumberGenerator= new BridgeRandomNumberGenerator();
        initBridgeGame(bridgeNumberGenerator);
    }

    private void initBridgeGame(BridgeNumberGenerator generator){
        service.initBridgeGame(generator, inputView.readBridgeSize());
    }
}