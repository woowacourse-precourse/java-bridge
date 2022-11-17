package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> bridge = new ArrayList<>();

    // TODO: 다리를 생성한다.
    public void createBridge(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.printInputLengthOfBridge();
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    // 리팩터링 필요
    //TODO: 이동하며 비교
    public void movingBridge(){
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MapMaker mapMaker = new MapMaker();
        OutputView.printEnter();

        int order = 0;
        while ( order < bridge.size() ){
            OutputView.printInputDirectionToMove();
            String move = InputView.readMoving();
            boolean correctBridge = bridgeGame.move(order, move);

            mapMaker.createMap(move, correctBridge);
            mapMaker.printMap();

            if (!correctBridge){
                break;
            }

            OutputView.printEnter();
            order += 1;
        }
    }
}
