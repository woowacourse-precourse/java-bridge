package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputException;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/***
 * UI 로직과 비즈니스 로직을 연결해주는 클래스
 */
public class Controller {
    private InputView input = new InputView();
    private OutputView output = new OutputView();
    private InputException inputException = new InputException();
    private BridgeGame bridgeGame;



    public List<String> bridgeMaker() {
        int size = inputException.checkLengthBridge(input.readBridgeSize());
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        return bridge;
    }

    public void bridgeGame(List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
        while (bridgeGame.stateGame()) {
            if(!checkMoveSucess()){
                break;
            }
        }
        output.printResult(bridgeGame.getGameCount());
    }

    public boolean checkMoveSucess() {
        String upDown = inputException.checkUpDown(input.readMoving());
        if (!bridgeGame.move(upDown)) {
            if(!checkRetry()){
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean checkRetry() {
        String retryQuick = inputException.checkRetry(input.readGameCommand());
        if (bridgeGame.retry(retryQuick)) {
            bridgeGame.setup();
            return true;
        }
        return false;
    }
}
