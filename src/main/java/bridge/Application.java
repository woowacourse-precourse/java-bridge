package bridge;

import bridge.controller.BridgeController;

import java.util.*;

public class Application {
    static BridgeController bridgeController = new BridgeController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        bridgeController.gameStart();
    }
}
