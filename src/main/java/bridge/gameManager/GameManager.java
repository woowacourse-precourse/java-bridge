package bridge.gameManager;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.gameComponent.Bridge;
import bridge.gameComponent.BridgeGame;
import bridge.util.MoveResult;
import bridge.validator.InputValidator;
import bridge.viewer.InputView;
import bridge.viewer.OutputView;

public class GameManager {
    private InputView inputView;
    private InputValidator inputValidator;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;
    private MoveResult moveResult;

    // 의존성 설정
    public GameManager() {
        this.inputValidator = new InputValidator();
        this.inputView = new InputView(this.inputValidator);
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        moveResult = MoveResult.CORRECT;
    }

    public void start() {
        setBridge();
        while(moveResult == MoveResult.CORRECT) {
            moveResult = move();
            if (moveResult == MoveResult.WRONG && inputView.readRetry()) reset();
        }
        endGame();
    }
    private void reset() {
        bridgeGame.retry();
        moveResult = MoveResult.CORRECT;
    }
    // 다리 생성
    private void setBridge() {
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = bridgeMaker.generateBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
    }

    // 게임 진행
    private MoveResult move() {
        String move = inputView.readMoving();
        MoveResult moveResult = bridgeGame.isCorrectMove(move);
        if(moveResult == MoveResult.CORRECT || moveResult == MoveResult.CORRECT_AND_LAST) bridgeGame.move();
        char[][] bridgeToCurrentPosition = bridgeGame.getBridgeToCurrentPosition(moveResult);
        int indexToPrint = bridgeGame.getCurrentStep();
        if(moveResult.equals(MoveResult.WRONG)) indexToPrint++;
        outputView.printMap(bridgeToCurrentPosition, indexToPrint);
        return moveResult;
    }
    // 게임 종료
    private void endGame() {
        boolean isSuccess = bridgeGame.isSuccess();
        int indexToPrint = bridgeGame.getCurrentStep();
        if(!isSuccess) indexToPrint++;
        outputView.printEndMessage();
        outputView.printMap(bridgeGame.getMapRecord(), indexToPrint);
        outputView.printResult(isSuccess, bridgeGame.getNumberOfTrials());
    }
}
