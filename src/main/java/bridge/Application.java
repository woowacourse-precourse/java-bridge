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
        setPlayer();
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void start() {
        bridgeGame.plusTryCount();
        bridgeGame.resetGameData();
        System.out.println(playerSetting.getPlayerBridge());
        boolean correct;
        do {
            correct = isCorrectMove();
        } while (canNotEnd(correct));
    }

    private static void restart() {
        // 1. 재시작
        // 1.1. start() 메소드 실행
        // 2. 종료
        // 2.1. 결과 출력
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

    private static boolean canNotEnd(boolean correct) {
        if(isSuccessful()) {
            return false;
        }
        return correct;
    }

    private static boolean isSuccessful() {
        if(bridgeGame.getPlayerLocation() >= playerSetting.getPlayerBridgeSize()) {
            // 성공시 프린트
            return true;
        }
        return false;
    }
}
