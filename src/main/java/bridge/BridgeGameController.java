package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<String> movement = new ArrayList<>();

    public int start() {
        int size = inputView.readBridgeSize();
        bridgeGame.start(size);
        return size;
    }

    public boolean move(int size) {
        movement.clear();
        boolean moved = false;
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
        return bridgeGame.retry(command);
    }

    public void printResult(boolean succeed, int cnt) {
        Message.GAME_RESULT.print();
        outputView.printResult(movement, movement.size() - 1, succeed);
        if (succeed) {
            Message.GAME_SUCCESS.print();
        }
        if (!succeed) {
            Message.GAME_FAILURE.print();
        }
        System.out.println(Message.GAME_TRIAL.getMessage() + cnt);
    }
}
