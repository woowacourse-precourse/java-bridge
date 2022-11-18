package bridge.service;

import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeGameConsole {

    // Message
    public void gameStartMessage(){
        printStartMessage();
    }

    public void movementDirectionInputRequestMessage() {
        printInputDirectionMessage();
    }

    public void bridgeSizeInputRequestMessage() {
        printInputBridgeSizeMessage();
    }

    // Util
    public void gameResult(List<String> topGameBoard, List<String> bottomGameBoard) {
        printResult(topGameBoard, bottomGameBoard);
    }

    public void gameStatistics(boolean gameResult, int tryCnt) {
        printGameStatistics(gameResult, tryCnt);
    }

    public void map(List<String> topGameBoard, List<String> bottomGameBoard) {
        printMap(topGameBoard, bottomGameBoard);
    }

    // Input
    public int inputBridgeSize(){
        return readBridgeSize();
    }

    public String moveForward(){
        return readMoving();
    }

    public boolean askRetry() {
        return readGameCommand();
    }
}
