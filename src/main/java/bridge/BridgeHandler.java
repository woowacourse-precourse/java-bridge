package bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeHandler {
    public void run(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean result = moveStep(bridgeGame);
    }

    public boolean moveStep(BridgeGame bridgeGame){
        int bridgeSize = bridgeGame.getBridgeSize();
        List<String> trace = new ArrayList<>();
        String updown;
        for (int step = 0; step < bridgeSize; step++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            updown = InputView.readMoving();
            trace.add(updown);
            if(!bridgeGame.move(updown, step)){
                OutputView.printMap(trace, false);
                return false;
            }
            OutputView.printMap(trace, true);
        }
        return true;
    }
}
