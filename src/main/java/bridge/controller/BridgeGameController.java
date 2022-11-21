package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Plate;
import bridge.util.Rules;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        startNewGame();
        createNewBridge();
        playGame();
        gameResult();
    }

    /**
     * 1. 게임 시작(출력)
     */
    public void startNewGame() {
        outputView.printStart();
    }

    /**
     * 2. 새로운 다리 만들기(입력)
     */
    public void createNewBridge() {
        try {
            int bridgeLength = inputView.readBridgeSize();
            bridgeGame.newBridge(bridgeLength);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            createNewBridge();
        }
    }

    /**
     * 3. 게임 시작
     */
    // 3-1. 한 라운드를 진행 시키는 메소드를 호출 그 결과 성공하지 못했다면 재시작 여부 확인
    public void playGame() {
        playRound();
        if (!(bridgeGame.isSuccessCrossingBridge())) {
            askRetry();
        }
    }

    // 3-2. 완전히 성공하거나 떨어질 때 까지 건널 다리를 선택
    public void playRound() {
        selectPlate();
        if (isSuccessAndNotVictory()) {
            playRound();
        }
    }

    private boolean isSuccessAndNotVictory() {
        return (!bridgeGame.isSuccessCrossingBridge())
                && (bridgeGame.isSuccessNextStep());
    }

    // 3-3. 다리를 선택(입력)
    public void selectPlate() {
        try {
            String nextStep = inputView.readMoving();
            moveBridge(nextStep);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            selectPlate();
        }
    }

    // 3-4. 선택한 다리로 이동 후 경로 표시(출력)
    public void moveBridge(String nextStep) {
        bridgeGame.move(nextStep);
        outputView.printMap(bridgeGame.isSuccessNextStep(), bridgeGame.getPlayerPath());
    }

    // 3-5. 게임 재시작 여부 선택(입력)
    public void askRetry() {
        try {
            String retryRorQ = inputView.readGameCommand();
            decideRetryOrQuit(retryRorQ);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            askRetry();
        }
    }

    // 3-6. 재시작 선택시 재시작하는 메소드 호출
    private void decideRetryOrQuit(String retryRorQ) {
        if (retryRorQ.equals(Rules.GAME_RETRY)) {
            bridgeGame.retry();
            playGame();
        }
    }

    /**
     * 4. 결과(출력)
     */
    public void gameResult() {
        boolean isVictory = bridgeGame.isSuccessCrossingBridge();
        int tryCount = bridgeGame.getTryCount();
        List<Plate> playerPath = bridgeGame.getPlayerPath();
        outputView.printResult(isVictory, tryCount, playerPath);
    }
}
