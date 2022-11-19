package bridge.controller;

import bridge.config.ClassConfig;
import dto.Result;

import java.util.List;
import java.util.stream.IntStream;

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
    }

    private int printAndInputBridgeSize() {
        classConfig.outputView().printInputBridgeLength();
        return classConfig.inputView().readBridgeSize();
    }

    private void playGame(List<String> bridges) {
        IntStream.range(0, bridges.size()).forEach(index -> {
            String movement = printAndInputMovement();
            correctBridge = classConfig.bridgeGame().move(movement, bridges, index);
            classConfig.outputView().printMap(correctBridge, movement);
            if (isCorrectBridge(bridges)) {
                return;
            }
            PrintSuccessGameResult(bridges, index);
        });
    }

    private void PrintSuccessGameResult(List<String> bridges, int index) {
        if (index == bridges.size() - 1) {
            classConfig.outputView().printResult(new Result(SUCCESS, count));
        }
    }

    private boolean isCorrectBridge(List<String> bridges) {
        if (!correctBridge) {
            classConfig.outputView().printRestartOrQuit();
            String gameCommand = classConfig.inputView().readGameCommand();
            restart = classConfig.bridgeGame().retry(gameCommand);
            if (isRestart(bridges)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRestart(List<String> bridges) {
        if (restart) {
            retryGame(bridges);
            return true;
        }
        if (!restart) {
            printFailureGameResult();
            return true;
        }
        return false;
    }

    private void printFailureGameResult() {
        classConfig.outputView().printResult(new Result(FAILURE, count));
    }

    private void retryGame(List<String> bridges) {
        count++;
        classConfig.outputView().setUpBridge();
        classConfig.outputView().setDownBridge();
        playGame(bridges);
    }

    private String printAndInputMovement() {
        classConfig.outputView().printSelectMovement();
        return classConfig.inputView().readMoving();
    }
}
