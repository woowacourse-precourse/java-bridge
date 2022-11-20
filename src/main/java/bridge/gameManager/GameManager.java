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
    private MoveResult moveResult; //0 -> 오답, 1-> 정댭, 2->끝까지 성공
    private boolean isGameOver;

    // 의존성 설정
    public GameManager() {
        this.inputValidator = new InputValidator();
        this.inputView = new InputView(this.inputValidator);
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        moveResult = MoveResult.Correct;
        isGameOver = false;
    }

    public void start() {
        setBridge();
        while(!isGameOver) {
            while(moveResult == MoveResult.Correct) moveResult = move();
            if(moveResult == MoveResult.CorrectAndLast) break;
            isGameOver = !inputView.readRetry();
            if(!isGameOver) {
                moveResult = MoveResult.Correct;
                bridgeGame.retry();
            }
        }
        endGame();
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
        if(moveResult == MoveResult.Correct || moveResult == MoveResult.CorrectAndLast) bridgeGame.move();
        char[][] mapRecord = bridgeGame.recordMap(moveResult);
        int indexToPrint = bridgeGame.getCurrentStep();
        if(moveResult.equals(MoveResult.Wrong)) indexToPrint++;
        outputView.printMap(mapRecord, indexToPrint);
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
