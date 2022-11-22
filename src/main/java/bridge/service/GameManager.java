package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.utils.constants.Comments;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void run() {
        GameResult gameResult = new GameResult();
        int bridgeSize = inputBridgeSize();
        Bridge bridge = makeBridge(bridgeSize);

        progressGame(gameResult, bridge);
    }

    /**
     * afterPhase()로부터
     * true를 리턴받으면 게임을 재시작 해야 하므로, return
     * false를 리턴받으면 게임이 종료되어야 하므로 gameEnd() 호출
     */
    private void progressGame(GameResult gameResult, Bridge bridge) {
        startPhase(gameResult, bridge);
        if (afterPhase(gameResult, bridge)) {
            return;
        }
        gameEnd(gameResult);
    }

    /**
     * 사용자로부터 다리의 크기를 입력받는다.
     */
    private int inputBridgeSize() {
        outputView.gameStart();
        outputView.chooseBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printLine();
        return bridgeSize;
    }

    /**
     * 입력받은 다리의 크기를 이용해서 다리를 생성한다.
     */
    private Bridge makeBridge(int bridgeSize) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void startPhase(GameResult gameResult, Bridge bridge) {
        while (gameResult.isNotGameEnd(bridge.getBridgeSize())) {
            progressPhase(gameResult, bridge);
        }
    }

    /**
     * 사용자로부터 이동할 위치를 입력받고, 현재 진행 상황을 출력한다.
     */
    private void progressPhase(GameResult gameResult, Bridge bridge) {
        outputView.chooseMovePlace();
        String place = inputView.readMoving();
        bridgeGame.move(bridge, gameResult, place);
        outputView.printMap(gameResult);
    }

    private boolean afterPhase(GameResult gameResult, Bridge bridge) {
        if (gameResult.isGameSuccess(bridge.getBridgeSize())) {
            return false;
        }
        return progressRestart(gameResult, bridge);
    }

    /**
     * 게임 재시작을 관리한다.
     * "R"을 입력받으면 retry() 메서드를 실행시키고 true를 return
     * "Q"를 입력받으면 false를 return
     */
    private boolean progressRestart(GameResult gameResult, Bridge bridge) {
        String restart = readRestartOrNot();
        if (restart.equals(Comments.GAME_RESTART.getComment())) {
            bridgeGame.retry(gameResult);
            progressGame(gameResult, bridge);
            return true;
        }
        return false;
    }

    private String readRestartOrNot() {
        outputView.chooseGameRestart();
        return inputView.readGameCommand();
    }

    private void gameEnd(GameResult gameResult) {
        outputView.printResult(gameResult);
    }
}
