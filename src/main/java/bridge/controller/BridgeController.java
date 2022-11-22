package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();
    public List<String> start(){
        String BridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(BridgeSize));
        return bridge;
    }
    public void repeat(List<String> bridge) {
        try {
            bridgeGame.movedResult.clear();
            for (int i=0; i<bridge.size(); i++){
                String moving = inputView.readMoving();
                List<String> movedResult = bridgeGame.move(moving);
                outputView.printMap(movedResult,bridge);
                if (!(bridge.get(i).equals(movedResult.get(i)))) {
                    break;
                }
            }
            outputView.printResult();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

}
