package bridge;

import bridge.controller.BridgeGame;

import static bridge.controller.BridgeGame.round;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setting();
        bridgeGame.make();
        bridgeGame.move();
        if(!bridgeGame.check()){
            bridgeGame.retry();
        }

        while(round != BridgeGame.bridge.size()){
            bridgeGame.move();
            if(!bridgeGame.check()){
                bridgeGame.retry();
            }

        }

        bridgeGame.getResult();
       // bridgeGame.challengeCount();
    }
}
