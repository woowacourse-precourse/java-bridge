package bridge.gameManager;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.gameComponent.Bridge;
import bridge.gameComponent.BridgeGame;
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
    private int isRightAnswer; //0 -> 오답, 1-> 정댭, 2->끝까지 성공
    private boolean isGameOver;

    // 의존성 설정
    public GameManager() {
        this.inputValidator = new InputValidator();
        this.inputView = new InputView(this.inputValidator);
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        isRightAnswer = 1;
        isGameOver = false;
    }

    public void start() {
        setBridge();
        while(!isGameOver) {
            while(isRightAnswer == 1) isRightAnswer = processGame();
            if(isRightAnswer == 2) break;
            isGameOver = !inputView.readRetry();
            if(!isGameOver) {
                isRightAnswer = 1;
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
    private int processGame() {
        String move = inputView.readMoving();
        int isPossibleMove = bridgeGame.isCorrectMove(move);
        if(isPossibleMove >= 1) bridgeGame.move();
        char[][] mapRecord = bridgeGame.recordMap(isPossibleMove);
        int indexToPrint = bridgeGame.getIndex();
        if(isPossibleMove == 0) indexToPrint++;
        outputView.printMap(mapRecord, indexToPrint);
        return isPossibleMove;
    }
    // 게임 종료
    private void endGame() {
        boolean isSuccess = bridgeGame.isSuccess();
        int indexToPrint = bridgeGame.getIndex();
        if(!isSuccess) indexToPrint++;
        outputView.printEndMessage();
        outputView.printMap(bridgeGame.getMapRecord(), indexToPrint);
        outputView.printResult(isSuccess, bridgeGame.getNumberOfTrials());
    }
}
