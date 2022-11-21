package bridge;

import bridge.service.BridgeGame;
import bridge.service.PlayerSetting;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final PlayerSetting playerSetting = new PlayerSetting();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            setPlayer();
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void start() {
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
            start();
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
