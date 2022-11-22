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
        return bridge;
    }

    public void bridgeGame(List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
        int bridgeIndex = 0;
        int gameCount = 0;
        while (true) {
            String upDown = inputException.checkUpDown(input.readMoving());
            boolean sucess = bridgeGame.move(upDown, bridgeIndex);
            if(!checkSucess(sucess, gameCount)){
                break;
            }
            gameCount++;
        }
    }

    public boolean checkSucess(boolean sucess, int gameCount) {
        if (!sucess) {
            gameCount++;
            output.printResult(gameCount);
            String retry = inputException.checkRetry(input.readGameCommand());
            if (!checkRetry(retry, gameCount)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRetry(String retry, int gameCount) {
        if (!bridgeGame.retry(retry)) {
            output.printResult(gameCount);
            return false;
        }
        return true;
    }


}
