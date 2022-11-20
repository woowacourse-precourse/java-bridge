package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        try {
            List<String> board = new ArrayList<>();
            Map<String, Integer> resultBoard = new HashMap<>();
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.start(new Record(board, resultBoard));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
