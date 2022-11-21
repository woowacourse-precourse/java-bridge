package Controller;

import bridge.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGameController() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    public void gameStart(){
        Bridge bridge = getBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!bridgeGame.isClear()){
            String movePosition = InputView.readMoving();
            bridgeGame.move(movePosition);
            OutputView.printMap(bridgeGame);
            if(bridgeGame.isFailure()){
                String restartCommand = InputView.readGameCommand();
                bridgeGame.retry(restartCommand);
            }
        }
    }

    private Bridge getBridge() {
        try {
            int bridgeSize = InputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        }
        catch (NumberFormatException exception){
            throw new IllegalArgumentException("3과 20사이의 숫자만 입력하셔야 합니다.");
        }
    }
}
