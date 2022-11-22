package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        try {
            List<String> bridgeList = bridgeGame.start();
            int count = bridgeGame.move(bridgeList);
            bridgeGame.gameResult(count);
        }catch (IllegalArgumentException e){
            bridgeGame.exceptionMessage(e);
        }
    }

}
