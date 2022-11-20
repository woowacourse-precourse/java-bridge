package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        boolean game=true;
        int count=0;
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridgeList = bridgeGame.start();
        count = playGame(game, count, bridgeGame, bridgeList);
        bridgeGame.gameResult(count);
    }

    private static int playGame(boolean game, int count, BridgeGame bridgeGame, List<String> bridgeList) {
        while(game) {
            count++;
            game = keepPlay(game, bridgeGame, bridgeList);
        }
        return count;
    }

    private static boolean keepPlay(boolean game, BridgeGame bridgeGame, List<String> bridgeList) {
        if (bridgeGame.move(bridgeList)){
            if (!bridgeGame.retry()){
                game = false;
            }
        }else {
            game =false;
        }
        return game;
    }
}
