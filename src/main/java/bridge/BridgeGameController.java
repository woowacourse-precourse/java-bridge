package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int start() {
        int size = inputView.readBridgeSize();
        bridgeGame.start(size);
        return size;
    }

    public boolean move(int size) {
        boolean moved = false;
        List<String> movement = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String command = inputView.readMoving();
            moved = bridgeGame.move(command, i);
            movement.add(command);
            outputView.printMap(movement, i, moved);
            if (!moved) {
                break;
            }
        }
        return moved;
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        if (command == "R") {
            return true;
        }
        return false;
    }
}
