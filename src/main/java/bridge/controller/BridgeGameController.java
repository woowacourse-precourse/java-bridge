package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.GameProgress;
import bridge.domain.GameResult;
import bridge.domain.GameTurn;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame game;
    private GameResult gameResult;

    public BridgeGameController() {
        // 객체 생성 및 다리 생성
        game = new BridgeGame();
    }

    public GameTurn playGame(GameTurn gameTurn) {
        if (gameTurn == GameTurn.MOVE) {
            gameResult = chooseWay();  // 길 선택
            return GameTurn.RESULT_CHECK;
        }

        if (!checkProgressAndContinue(gameResult.getProgress())) {  // 실패시 재시도할지 확인, 성공시 게임 종료
            return GameTurn.QUIT;
        }

        return GameTurn.MOVE;
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
