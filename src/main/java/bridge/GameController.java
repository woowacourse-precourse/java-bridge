package bridge;

import java.util.List;

public class GameController {
    BridgeGame game;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    int size;
    int attempts = 1;
    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        size = getBridgeSize(); // 다리 길이 입력
        List<String> answer = maker.makeBridge(size);
        running(answer);
    }

    private boolean runGame(int hitCount) {
        for(int i = 0; i < size; i++) {
            if (!playerMoving(hitCount)) return false;
        }
        return true;
    }
    private void running(List<String> answer) {
        int hitCount = 0;
        attempts++;
        game = new BridgeGame(answer); // 게임 세팅
//        while (!runGame(hitCount)) {
//            if (!isRetry()) break;
//        }
        outputView.printResult(isCompleted(hitCount), attempts, game.upBridge, game.downBridge);
    }

    private boolean playerMoving(int hitCount) {
        if (game.move(inputView.readMoving(), hitCount)) {
            hitCount++;
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

    private boolean isCompleted(int  hitCount) {
        return hitCount == size;
    }
}
