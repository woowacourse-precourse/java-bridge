package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.InputController;
import bridge.model.Record;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        try {
            List<String> board = new ArrayList<>();
            Map<String, Integer> resultBoard = new HashMap<>();
            InputController inputController = new InputController(new InputView());
            BridgeGameController bridgeGameController = new BridgeGameController();

            bridgeGameController.start(inputController.getBridgeSize(), new Record(board, resultBoard));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
