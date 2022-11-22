package bridge;

import static bridge.MessageView.*;

import java.util.List;

public class GameController {
    BridgeGame game;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    int size;
    int attempts = 0;
    boolean isSuccess = false;
    public void play() {
        System.out.println(START_GAME_MESSAGE);
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        size = getBridgeSize();
        List<String> answer = maker.makeBridge(size);
        running(answer);
    }



    private boolean runGame() {
        for(int i = 0; i < size; i++) {
            if (!playerMoving(i)) return false;
        }
        isSuccess = true;
        return true;
    }
    private void running(List<String> answer) {
        do {
            attempts++;
            game = new BridgeGame(answer); // 게임 세팅
            if (runGame()) break;
        } while (isRetry());

        outputView.printResult(isSuccess, attempts, game.upBridge, game.downBridge);
    }

    private boolean playerMoving(int index) {
        if (game.move(inputView.readMoving(), index)) {
            outputView.printMap(game.upBridge, game.downBridge);
            return true;
        }
        outputView.printMap(game.upBridge, game.downBridge);
        return false;
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    private boolean isRetry() {
        return game.retry(inputView.readGameCommand());
    }
}
