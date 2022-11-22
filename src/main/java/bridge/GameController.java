package bridge;

import java.util.List;

public class GameController {
    BridgeGame game;
    InputView inputView = new InputView();
    int size;
    int attempts = 1;
    String movingInput;
    public void play() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        size = getBridgeSize(); // 다리 길이 입력
        List<String> answer = maker.makeBridge(size);
        running(answer);
    }

    private void running(List<String> answer) {
        int hitCount = 0;
        game = new BridgeGame(answer); // 게임 세팅
        while(true) {
            if(hitCount == size) {
                return;
            }
            movingInput = inputView.readMoving();
            attempts++;
            if(!game.move(movingInput, hitCount)) { // 사용자 이동과 판별해서 틀리면
                if(isRetry()) {
                    continue;
                }
            }
            hitCount++;
        }
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    private boolean isRetry() {
        return game.retry(inputView.readGameCommand());
    }
}
