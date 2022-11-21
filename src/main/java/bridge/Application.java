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
        bridgeGame.check();

        while(round != BridgeGame.bridge.size()){
            bridgeGame.move();

            if(!bridgeGame.check()){
                //return;
                bridgeGame.retry();
            }

        }

        bridgeGame.getResult();
       // bridgeGame.challengeCount();
    }
}
