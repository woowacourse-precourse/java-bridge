package bridge.service;

import bridge.domain.GameBoard;

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
    public void gameResult(GameBoard topGameBoard, GameBoard bottomGameBoard) {
        printResult(topGameBoard, bottomGameBoard);
    }

    public void gameStatistics(boolean gameResult, int tryCnt) {
        printGameStatistics(gameResult, tryCnt);
    }

    public void map(GameBoard topGameBoard, GameBoard bottomGameBoard) {
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
