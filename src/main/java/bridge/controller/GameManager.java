package bridge.controller;

import bridge.model.Bridge;

public class GameManager {
    Bridge bridge;

    public void startGame() {
        
        bridge = new Bridge();
        System.out.println("bridge.getBridge() = " + bridge.getBridge());
    }
}
