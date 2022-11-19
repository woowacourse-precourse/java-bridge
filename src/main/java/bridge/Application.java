package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        inputView.readBridgeSize();
        bridgeGame.move();
        retry();
    }

    public static void retry() {
        while (true) {
            if (bridgeGame.failOrTure.equals("실패")) {
                bridgeGame.retry();
            }
            if (bridgeGame.failOrTure.equals("성공") || bridgeGame.retry().equals("Q")) {
                break;
            }
        }
    }
}
