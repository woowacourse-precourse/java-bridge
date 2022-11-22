package bridge;

import java.util.List;

public class GameController {
    BridgeGame game;
    InputView inputView = new InputView();
    int size;
    int attempts = 1;
    String movingInput;
    public void play() {
        int index = 0;
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        size = getBridgeSize();
        List<String> answer = maker.makeBridge(size);
        game = new BridgeGame(answer);
        while(attempts < size) {
            movingInput = inputView.readMoving();
            game.move(movingInput, index++);
            attempts++;
        }
    }

    public boolean isCorrect(String answer, String userInput) {
        if(userInput.equals(answer)) {
            return true;
        }
        return false;
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    private boolean isRetry() {
        return game.retry(inputView.readGameCommand());
    }
}
