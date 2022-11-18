package bridge;

import bridge.bridgeMaker.BridgeMaker;
import bridge.bridgeMaker.BridgeNumberGenerator;
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
        outputView.printResult();
    }

    private void createBridge() {
        outputView.printInputSizeMessage();
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private String move() {
        outputView.printInputMoveMessage();
        String moveBlock = inputView.readMoving();
        return moveBlock;
    }

    private boolean play() {
        boolean isSucess = false;
        boolean isRestart = true;
        do {
            countOfPlay++;
            for (int i = 0; i < bridgeSize; i++) {
                String moveBlock = move();
                boolean isMove = bridgeGame.move(moveBlock);
                outputView.printMap();
                if (!isMove) {
                    isRestart = readRestart();
                    break;
                }
            }
            if (!isRestart) {
                isSucess = true;
            }
        } while (!isSucess && isRestart);
        return isSucess;
    }

    private boolean readRestart() {
        String restart = inputView.readGameCommand();
        boolean isRestart = bridgeGame.retry(restart);
        return isRestart;
    }
}
