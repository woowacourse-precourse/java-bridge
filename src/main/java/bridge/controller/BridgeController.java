package bridge.controller;

import bridge.config.ClassConfig;
import bridge.dto.Result;

import java.util.List;

import static bridge.constant.GameResult.FAILURE;
import static bridge.constant.GameResult.SUCCESS;

public class BridgeController {

    private final ClassConfig classConfig;
    private int count = 1;
    private boolean correctBridge;
    private boolean restart;

    public BridgeController(ClassConfig classConfig) {
        this.classConfig = classConfig;
    }

    public void run() {
        classConfig.outputView().printStart();
        int size = printAndInputBridgeSize();
        List<String> bridges = classConfig.bridgeMaker().makeBridge(size);
        playGame(bridges);
        printSuccessGameResult();
    }

    private int printAndInputBridgeSize() {
        classConfig.outputView().printInputBridgeLength();
        return classConfig.inputView().readBridgeSize();
    }

    private void playGame(List<String> bridges) {
        for (int index = 0; index < bridges.size(); index++) {
            distinguishBridgeAndPrintMap(bridges, index);
            isCorrectBridge();
            if (retryGame(bridges)) {
                break;
            }
            if (endGame()) {
                return;
            }
        }
    }

    private void distinguishBridgeAndPrintMap(List<String> bridges, int index) {
        String movement = printAndInputMovement();
        correctBridge = classConfig.bridgeGame().move(movement, bridges, index);
        classConfig.outputView().printMap(correctBridge, movement);
    }

    private String printAndInputMovement() {
        classConfig.outputView().printSelectMovement();
        return classConfig.inputView().readMoving();
    }

    private void isCorrectBridge() {
        if (!correctBridge) {
            classConfig.outputView().printRestartOrQuit();
            String gameCommand = classConfig.inputView().readGameCommand();
            restart = classConfig.bridgeGame().retry(gameCommand);
        }
    }

    private boolean retryGame(List<String> bridges) {
        if (!correctBridge && restart) {
            setInitialBridge(bridges);
            return true;
        }
        return false;
    }

    private void setInitialBridge(List<String> bridges) {
        count++;
        classConfig.bridge().setUpBridge();
        classConfig.bridge().setDownBridge();
        playGame(bridges);
    }

    private boolean endGame() {
        if (!correctBridge && !restart) {
            printFailureGameResult();
            return true;
        }
        return false;
    }

    private void printFailureGameResult() {
        classConfig.outputView().printResult(new Result(FAILURE.getGameResult(), count));
    }

    private void printSuccessGameResult() {
        if (correctBridge) {
            classConfig.outputView().printResult(new Result(SUCCESS.getGameResult(), count));
        }
    }
}
