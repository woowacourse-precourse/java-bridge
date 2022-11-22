package bridge.service;

import java.util.List;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.GameInfo;
import bridge.utils.InputView;
import bridge.utils.OutputView;
import constants.*;

public class GameManager {

    BridgeGame bridgeGame;
    GameInfo gameInfo;

    public GameManager() {
        gameStart();
        gameEnd();
    }

    private void gameStart() {
        System.out.println(Messages.BRIDGE_GAME_START);
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
        if (gameInfo.getGameRound().equals(Constants.RETRY)) {
            String gameCommand = new InputView().readGameCommand();
            bridgeGame.retry(gameCommand);
        }
        if (gameInfo.getGameRound().equals(Constants.GAMEOVER))
            return;
        moveStart();
    }

    public void gameEnd() {
        new OutputView().printResult(bridgeGame.getBridgeMessage(), gameInfo);
    }
}
