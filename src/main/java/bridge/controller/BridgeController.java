package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private static final String success = "성공";
    public int count = 0;
    public List<String> start(){
        int BridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(BridgeSize);
        return bridge;
    }
    public boolean repeat(List<String> bridge) {
        bridgeGame.movedResult.clear();
        for (int i=0; i<bridge.size(); i++){
            String moving = inputView.readMoving();
            List<String> movedResult = bridgeGame.move(moving);
            outputView.printMap(movedResult,bridge);
            if(movedResult.equals(bridge)){
                count++;
                outputView.printResult(success,count);
                return true;
            }
            if (!(bridge.get(i).equals(movedResult.get(i)))) {
                break;
            }
        }
        count++;
        return false;
    }
}
