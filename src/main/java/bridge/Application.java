package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        // TODO: 프로그램 구현
        inputView.readBridgeSize();
        bridgeGame.move();
        while(true) {
            if (bridgeGame.failOrTure.equals("실패")) {
                bridgeGame.retry();
            }
            if(bridgeGame.failOrTure.equals("성공") || bridgeGame.retry().equals("Q")){
                break;
            }
        }
    }
}
