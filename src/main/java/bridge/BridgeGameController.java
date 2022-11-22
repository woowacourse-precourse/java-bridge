package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<String> movement = new ArrayList<>();
    private static int cnt = 0;

    public int start() {
        int size = inputView.readBridgeSize();
        bridgeGame.start(size);
        return size;
    }

    public boolean play(int size) {
        movement.clear();
        cnt++;
        for (int i = 0; i < size; i++) {
            if (!this.move(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean move(int idx) {
        String command = inputView.readMoving();
        boolean moved = bridgeGame.move(command, idx);
        movement.add(command);
        outputView.printMap(movement, idx, moved);
        return moved;
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        return bridgeGame.retry(command);
    }

    public void printResult(boolean succeed) {
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
