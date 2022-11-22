package bridge.domain;

import bridge.ui.Constant;
import bridge.ui.InputView;
import bridge.ui.OutputView;

/**
 * 다리 건너기 게임을 진행하는 클래스
 */
public class Referee {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    /**
     * 게임을 시작하는 메소드
     * 게임을 실패하거나 성공할 경우 종료
     */
    public void start() {
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        int gameResult = runningGame(bridgeGame);
        while (gameResult == Constant.GAME_RESTART) {
            bridgeGame.retry();
            gameResult = runningGame(bridgeGame);
        }
        outputView.printResult(gameResult, bridgeGame);
    }

    /**
     * 실질적인 게임 진행을 하는 메소드
     * 게임의 실패, 성공 여부와 재시작 여부를 반환함
     */

    private int runningGame(BridgeGame bridgeGame) {
        do {
            String inputGoingBlock = inputView.readMoving();
            if (!bridgeGame.move(inputGoingBlock)){
                outputView.printMap(bridgeGame, Constant.TOKEN_FAIL);
                return inputView.readGameCommand();
            }
            outputView.printMap(bridgeGame, Constant.TOKEN_CLEAR);
        } while (!bridgeGame.isClear());
        return Constant.GAME_CLEAR;
    }
}
