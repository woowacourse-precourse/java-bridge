package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.domain.User;
import bridge.service.BridgeGameService;
import bridge.service.BridgeMaker;
import bridge.service.BridgeRandomNumberGenerator;

public class BridgeGame {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private GameStatus gameStatus = new GameStatus();
    private User user = new User();
    private Bridge bridge = new Bridge();
    private BridgeGameService bridgeGameService = new BridgeGameService();

    public void startGame(int size) {
        bridge.setBridgeSize(size);
        bridge.setBridgeLoad(bridgeMaker.makeBridge(size));
        gameStatus.addGameCount();
    }

    public void move(String moving) {
        user.addNext(moving);
    }

    public String getMergeBridge() {
        BridgeGameService bridgeGameService = new BridgeGameService();
        bridgeGameService.setMergeBridge();
        return bridgeGameService.getMergeBridge();
    }

    public void retry() {
        user.clearLog();
        gameStatus.addGameCount();
    }

    public String endGame() {
        bridgeGameService.setEndMessage();
        return bridgeGameService.getEndMessage();
    }

    public boolean setMatch() {
        bridgeGameService.setMatch();
        return gameStatus.getMatchCorrect();
    }

    public boolean getMatchCorrect() {
        return gameStatus.getMatchCorrect();
    }

    public boolean checkAllCorrect() { // 따로 다시 마들기
        return bridgeGameService.checkAllCorrect();
    }
}
