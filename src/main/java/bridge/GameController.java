package bridge;

import java.util.List;

public class GameController {
    BridgeGame game = new BridgeGame();
    InputView inputView = new InputView();
    int size;
    int tryCnt;
    String movingInput;
    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        size = getBridgeSize();
        List<String> answer = maker.makeBridge(size);
        while(tryCnt < size) {
            movingInput = inputView.readMoving();
            game.move(tryCnt, movingInput);
            result(answer.get(tryCnt), movingInput);
            tryCnt++;
        }
    }

    public boolean result(String answer, String userInput) {
        if(userInput.equals(answer)) {
            return true;
        }
        return false;
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }
}
