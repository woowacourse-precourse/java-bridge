package bridge.gameManager;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.gameComponent.Bridge;
import bridge.gameComponent.BridgeGame;
import bridge.gameComponent.InputValidator;
import bridge.util.MoveResult;
import bridge.gameComponent.InputValidatorImpl;
import bridge.viewer.InputView;
import bridge.viewer.OutputView;

import static bridge.util.MoveResult.CORRECT;
import static bridge.util.MoveResult.WRONG;

public class GameManager {
    private InputView inputView;
    private InputValidator inputValidator;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;
    private MoveResult moveResult;

    // 의존성 설정
    public GameManager() { //TODO: interface
        this.inputValidator = new InputValidatorImpl();
        this.inputView = new InputView(this.inputValidator);
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        moveResult = CORRECT;
    }

    public void start() {
        setBridge();
        while(moveResult == CORRECT) {
            moveResult = moveTry(inputView.readMoving());
            if (moveResult == WRONG && inputView.readRetry()) {
                reset();
            }
        }
        endGame();
    }
    private void reset() {
        bridgeGame.retry();
        moveResult = CORRECT;
    }
    // 다리 생성
    private void setBridge() {
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = bridgeMaker.generateBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
    }

    // 게임 진행
    private MoveResult moveTry(String move) {
        MoveResult moveResult = bridgeGame.isCorrectMove(move);
        bridgeGame.moveForward(moveResult, move);
        char[][] bridgeResult = bridgeGame.getCurrentBridge(moveResult);
        int bridgeIndex = getBridgeIndex(moveResult);
        outputView.printMap(bridgeResult, bridgeIndex);
        return moveResult;
    }
    private int getBridgeIndex(MoveResult moveResult) {
        int bridgeIndex = bridgeGame.getBridgeIndex();
        if(moveResult.equals(WRONG)) bridgeIndex++;
        return bridgeIndex;
    }
    // 게임 종료
    private void endGame() {
        boolean isSuccess = bridgeGame.isSuccess();
        int bridgeIndex = bridgeGame.getBridgeIndex();
        if(!isSuccess) bridgeIndex++;
        outputView.printEndMessage();
        outputView.printMap(bridgeGame.getMoveRecord(), bridgeIndex);
        outputView.printResult(isSuccess, bridgeGame.getNumberOfTrials());
    }
}
