package bridge;

import bridge.input.InputView;
import bridge.outputView.OutputView;

import java.util.List;

public class GameStart {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    boolean isSuccess;
    boolean isRestart;
    int countOfPlay;


    public GameStart() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
    }

    public void run() {
        start();
        while (!isSuccess && isRestart) {
            countOfPlay++;
            isSuccess = play();
            isRestart = checkRestart(isSuccess);
        }
        outputView.printResult(bridge.size()-1, isSuccess, countOfPlay);
    }

    private boolean play() {
        for (int countOfMove = 0; countOfMove < bridge.size(); countOfMove++) {
            boolean isMove = move(countOfMove);
            if (!isMove) {
                return false;
            }
        }
        return true;
    }

    private void start() {
        outputView.printStartMessage();
        inputBridge();
        outputView.setBridge(bridge);
        isSuccess = false;
        isRestart = true;
        countOfPlay = 0;
    }

    private boolean move(int countOfMove) {
        String moveBlock = inputMove();
        boolean isMove = bridgeGame.move(bridge, countOfMove, moveBlock);
        outputView.printMap(countOfMove, isMove);
        return isMove;
    }

    private boolean checkRestart(boolean isSuccess) {
        boolean isRestart = true;
        if (!isSuccess) {
            isRestart = inputRestart();
        }
        return isRestart;
    }

    private void inputBridge() {
        int bridgeSize = 0;
        while (bridgeSize == 0) {
            outputView.printInputSizeMessage();
            bridgeSize = inputView.readBridgeSize();
        }
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private String inputMove() {
        String moveBlock = "";
        while (moveBlock.equals("")) {
            outputView.printInputMoveMessage();
            moveBlock = inputView.readMoving();
        }
        return moveBlock;
    }

    private boolean inputRestart() {
        String restart = "";
        while (restart.equals("")) {
            outputView.printRestartMessage();
            restart = inputView.readGameCommand();
        }
        boolean isRestart = bridgeGame.retry(restart);
        return isRestart;
    }
}
