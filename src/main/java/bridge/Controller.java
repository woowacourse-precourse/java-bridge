package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        printGameStartMsg();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        int userTry = 1;
        move(bridge, bridgeSize, userTry);
    }

    private void printGameStartMsg(){
        inputView.getBridgeGameStartMsg();
        inputView.getInputBridgeLengthMsg();
    }

    private void move(Bridge bridge, int bridgeSize, int userTry){
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int step = 0;
        boolean quitFlag = false;
        boolean retryFlag = false;
        while(step != bridgeSize){
            inputView.getInputMoveUpOrDownMsg();
            String moving = inputView.readMoving();
            boolean isEqual = bridgeGame.move(moving, step);
            outputView.printMap(bridgeGame);
            if (!isEqual){
                inputView.getInputRestartOrQuitMsg();
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("Q")) {
                    quitFlag = true;
                    break;
                }
                if (gameCommand.equals("R")){
                    retryFlag = true;
                    break;
                }
            }
            step++;
        }
        if (quitFlag || step == bridgeSize){
            printResult(bridgeGame, quitFlag, userTry);
        }
        if (retryFlag){
            bridgeGame.retry();
            move(bridge, bridgeSize, userTry+1);
        }
    }

    private void printResult(BridgeGame bridgeGame, boolean quitFlag, int userTry){
        outputView.printResult(bridgeGame, quitFlag, userTry);
    }
}
