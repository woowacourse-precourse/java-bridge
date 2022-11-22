package bridge;

import bridge.bridgeMaker.BridgeMaker;
import bridge.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.input.InputView;

import java.util.List;

public class GameStart {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private int bridgeSize;
    private List<String> bridge;
    private int countOfPlay;
    private int countOfMove;

    public GameStart() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        countOfPlay = 0;
    }

    public void run() {
        createBridge();
        boolean isSuccess = play();
        outputView.printResult(bridge, countOfMove, isSuccess, countOfPlay);
    }

    private void createBridge() {
        do {
            outputView.printInputSizeMessage();
            bridgeSize = inputView.readBridgeSize();
        } while (bridgeSize == 0);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private String inputMove() {
        String moveBlock = "";
        do {
            outputView.printInputMoveMessage();
            moveBlock = inputView.readMoving();
        } while (moveBlock.equals(""));
        return moveBlock;
    }

    private boolean play() {
        boolean isSuccess = false;
        boolean isRestart = true;
        do {
            countOfPlay++;
            for (countOfMove = 0; countOfMove < bridgeSize; countOfMove++) {
                String moveBlock = inputMove();
                boolean isMove = bridgeGame.move(bridge, countOfMove, moveBlock);
                outputView.printMap(bridge, countOfMove, isMove);
                if (!isMove) {
                    isRestart = inputRestart();
                    break;
                }
            }
            if (!isRestart) {
                isSuccess = true;
            }
        } while (!isSuccess && isRestart);
        return isSuccess;
    }

    private boolean inputRestart() {
        String restart = "";
        do {
            outputView.printRestartMessage();
            restart = inputView.readGameCommand();
        } while (restart.equals(""));
        boolean isRestart = bridgeGame.retry(restart);
        return isRestart;
    }
}
