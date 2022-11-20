package bridge.controller;

import bridge.BridgeGame;
import bridge.model.Bridge;
import bridge.model.User;

public class GameManager {
    Bridge bridge;
    User user;
    BridgeGame bridgeGame;

    public GameManager(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        
        bridge = new Bridge();
        System.out.println("bridge.getBridge() = " + bridge.getBridge());
    }

    public void playGame() {
        while (true) {
            user.addUserCommand();
            bridgeGame.move(bridge.getBridge(), user.getUserCommand());

        }
    }
}
