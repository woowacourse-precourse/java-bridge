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
    private int count = 1;
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
                outputView.printResult();
                System.out.println("게임 성공 여부: 성공");
                System.out.println("총 시도한 횟수: "+count);
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
