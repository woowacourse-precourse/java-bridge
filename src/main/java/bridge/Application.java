package bridge;

import bridge.model.Model;
import bridge.view.InputView;
import bridge.view.MSG;
import bridge.view.OutputView;

import static bridge.view.InputView.*;
import static bridge.view.MSG.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println(INPUT_START.message);
        BridgeGame bridgeGame = new BridgeGame(readBridgeSize());
        System.out.println();

        boolean retry = true;
        while (retry){
            boolean moveResult = true;
            while (moveResult) {
                moveResult = bridgeGame.move(readMoving());
                OutputView.printMap();
            }
            retry = bridgeGame.retry(readGameCommand());
        }
        OutputView.printResult();
    }
}
