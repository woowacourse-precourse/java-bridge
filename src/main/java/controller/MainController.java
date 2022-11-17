package controller;

import model.User;
import view.InputView;
import view.OutputView;

public class MainController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void run(){
        startGame();
        User user = getUserIncludeBridgeSize();

    }

    private void startGame(){
        outputView.printStartGame();
    }

    public User getUserIncludeBridgeSize(){
        printReceiveBridgeSize();
        int bridgeSize = readBridgeSize();
        return new User(bridgeSize);
    }



    private void printReceiveBridgeSize(){
        outputView.printReceiveBridgeSize();
    }

    private int readBridgeSize(){
        return inputView.readBridgeSize();
    }
}
