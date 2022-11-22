package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.GameProgress;
import bridge.domain.GameResult;

public class BridgeGameController {
    private final BridgeGame game;

    public BridgeGameController() {
        // 객체 생성 및 다리 생성
        game = new BridgeGame();
    }

    public void playGame() {
        while (true) {
            GameResult gameResult = chooseWay();  // 길 선택
            if(!checkProgressAndContinue(gameResult.getProgress())) {  // 실패시 재시도할지 확인, 성공시 게임 종료
                break;
            }
        }
    }

    private GameResult chooseWay() {
        // 길 입력받기
        game.move();
        // 결과확인
        GameResult gameResult = game.getResult();
        BridgeGame.printGameResult(gameResult);

        return gameResult;
    }

    private boolean checkProgressAndContinue(GameProgress progress) {
        // 실패시 재시도할지 확인
        if (progress == GameProgress.FAILURE && !game.retry()) {
                return false;
        }
        // 성공시 게임 종료
        return progress != GameProgress.SUCCESS;
    }
}
