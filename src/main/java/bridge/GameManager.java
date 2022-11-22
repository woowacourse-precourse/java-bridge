package bridge;

import java.util.List;

public class GameManager {

    BridgeGame bridgeGame;
    GameInfo gameInfo;

    public GameManager() {
        gameStart();
        gameEnd();
    }

    private void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        initGameSource();
    }

    private void initGameSource() {
        int bridgeSize = new InputView().readBridgeSize();
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);

        gameInfo = new GameInfo();
        bridgeGame = new BridgeGame(bridge, gameInfo);

        moveStart();
    }

    private void moveStart() {
        String moving = new InputView().readMoving();

        bridgeGame.makeBridgeMessage(moving);
        bridgeGame.checkSuccessOrFail(moving);
        bridgeGame.move();

        new OutputView().printMap(bridgeGame.getBridgeMessage());
        checkProgress();
    }

    private void checkProgress() {
        if (gameInfo.getGameRound().equals("Retry")) {
            String gameCommand = new InputView().readGameCommand();
            bridgeGame.retry(gameCommand);
        }
        if (gameInfo.getGameRound().equals("GameOver"))
            return;
        moveStart();
    }

    public void gameEnd() {
        new OutputView().printResult(bridgeGame.getBridgeMessage(), gameInfo);
    }
}
