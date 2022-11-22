package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.PlayerSetting;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Game {
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final PlayerSetting playerSetting = new PlayerSetting();

    public void start() {
        try {
            setPlayer();
            play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void play() {
        bridgeGame.plusTryCount();
        bridgeGame.resetGameData();
        while (isCorrectMove()) {
            if (isSuccessful()) {
                return;
            }
        }
        restart();
    }

    private static void restart() {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            play();
        }
        outputView.printResult(false, bridgeGame.getHistoryMap(), bridgeGame.getTryCount());
    }

    private static void setPlayer() {
        String bridgeLength = inputView.readBridgeSize();
        PlayerSetting.setBridgeSizeToPlayer(bridgeLength);
        bridgeGame.start();
    }

    private static boolean isCorrectMove() {
        String commend = inputView.readMoving();
        boolean result = bridgeGame.move(commend);
        outputView.printMap(bridgeGame.getHistoryMap());
        return result;
    }

    private static boolean isSuccessful() {
        if (bridgeGame.getPlayerLocation() >= playerSetting.getPlayerBridgeSize()) {
            outputView.printResult(true, bridgeGame.getHistoryMap(), bridgeGame.getTryCount());
            return true;
        }
        return false;
    }
}
