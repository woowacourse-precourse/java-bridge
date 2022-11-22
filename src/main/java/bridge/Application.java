package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Bridge {
    private GameUI gameUI;
    private InputView inputView;
    private BridgeMaker bridgeMaker;
    public List<String> gameStart() {
        gameUI.gameStart();
        gameUI.getBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void gamePlay(List<String> bridgeShape) {
        List<Integer> playerMove = new ArrayList<>();
        for (int i = 0; i < bridgeShape.size(); i++) {
            movingPlayer(bridgeShape.get(i), playerMove);
        }
    }

    public void movingPlayer(String bridgeShape, List<Integer> playerMove) {
        BridgeGame bridgeGame = new BridgeGame();
        gameUI.moving();
        String moving = inputView.readMoving();
        playerMove.add(bridgeGame.move(moving, bridgeShape));
    }
}