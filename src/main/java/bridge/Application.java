package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeMaker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.go();


    }
}
