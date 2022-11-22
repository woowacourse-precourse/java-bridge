package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Bridge bridge = new Bridge();
        List<String> bridgeSize = bridge.gameStart();
        bridge.gamePlay(bridgeSize);
    }
}

class Bridge {
    private final GameUI gameUI = new GameUI();
    private final InputView inputView = new InputView();
    private BridgeMaker bridgeMaker;
    private final OutputView outputView = new OutputView();
    public List<String> gameStart() {
        gameUI.gameStart();
        gameUI.getBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void gamePlay(List<String> bridgeShape) {
        List<Integer> moveOutcome = new ArrayList<>();
        List<String> playerMoving = new ArrayList<>();
        for (int i = 0; i < bridgeShape.size(); i++) {
            movingPlayer(playerMoving);
            compareMove(bridgeShape.get(i), playerMoving.get(i), moveOutcome);
            outputView.printMap(playerMoving, moveOutcome);
        }
    }

    public void movingPlayer(List<String> playerMoving) {
        gameUI.moving();
        playerMoving.add(inputView.readMoving());
    }

    public void compareMove(String bridgeShape, String playerMoving, List<Integer> moveOutcome) {
        BridgeGame bridgeGame = new BridgeGame();
        moveOutcome.add(bridgeGame.move(playerMoving, bridgeShape));
    }
}