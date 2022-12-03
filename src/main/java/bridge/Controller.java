package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.utils.constant.Constant.*;

public class Controller {

    private final InputView inputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;

    public Controller(InputView inputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker, OutputView outputView) {
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.outputView = outputView;
    }

    void play() {
        String quit;
        outputView.printGameStart();
         do{
            outputView.printBridgeSize(); //
            int size = inputView.readBridgeSize();///
            List<String> bridge = bridgeMaker.makeBridge(size);

            quit = whileQuitIsR(bridge);
        } while(!quit.equals(QUIT.getValue()));
    }
    public String whileQuitIsR(List<String> bridge) {
        int attempt = 0;
        String failed;
        String quit = RESTART.getValue();
        do {
            failed = crossingBridge(bridge);
            attempt = bridgeGame.retry(attempt, quit);
            quit = askQuit(failed);
        } while (!quit.equals(QUIT.getValue()));
        printResult(failed, attempt);
        return quit;
    }

    public void printResult(String failed, int attempt) {
        outputView.printResult(bridgeGame.toString());//
        outputView.gameAttemptCount(failed, attempt);//
    }
    public String crossingBridge(List<String> bridge) {
        clearBridges();
        return successCrossingBridge(bridge);
    }

    public void clearBridges() {
        bridgeGame.clearBridges();
    }

    public String successCrossingBridge(List<String> bridge) {
        for (String s : bridge) {
            outputView.printWhereToMove();//
            String direction = inputView.readMoving();///
            List<List<String>> bridges = bridgeGame.move(direction, s);
            outputView.printMap(bridgeGame.toString());//
            if (endOfTheGame(bridges).equals(FAILED.getValue())) {
                return FAILED.getValue();
            }
        }
        return SUCCESS.getValue();
    }

    public String endOfTheGame(List<List<String>> bridges) {
        int last = bridges.get(0).size();
        List<String> bridgeUp = bridges.get(0);
        List<String> bridgeDown = bridges.get(1);

        if(bridgeUp.get(last -1).contains(X.getValue()) || bridgeDown.get(last - 1).contains(X.getValue())) {
            return FAILED.getValue();
        } return SUCCESS.getValue();
    }

    public String askQuit(String failed) {
        String quit;

        if(failed.equals(FAILED.getValue())) {
            outputView.askRestartGame();//
            quit = inputView.readGameCommand();///
            return quit;
        }
        quit = QUIT.getValue();
        return quit;
    }
}
