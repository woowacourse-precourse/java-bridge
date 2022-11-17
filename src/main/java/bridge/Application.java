package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = InputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(size);
        boolean gameSuccess = true;
        List<String> nowBridge = new ArrayList<>();

        while(gameSuccess == true){
            String pick = InputView.readMoving();
            bridgeGame.move(pick, nowBridge);
            gameSuccess = bridgeGame.compareBridge(nowBridge, generatedBridge);
        }
    }
}