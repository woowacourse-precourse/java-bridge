package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.View.StaticView;

import java.util.List;
import java.util.Objects;

import static bridge.RetryOrQuit.*;
import static bridge.View.InputView.bridgeSize;


public class Controller {
    BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(generator); //위에랑 세트로 한번만쓰임
    InputView inputView = new InputView();
    BridgeGame bridgeGame;
    OutputView outputView = new OutputView();
    StaticView staticView = new StaticView();

    public void run() {
//        =========================== ! 1회만 실행될 애들
        staticView.gameStartMsg();
        staticView.askSizeMsg();
        inputView.readBridgeSize();
        setBridge();
//        =========================== !

        String command;

        do {
            playGame();

            staticView.askRetryMsg();
            command = inputView.readGameCommand();
            if (Objects.equals(command, RETRY.getMessage())) {
                bridgeGame.retry();
            }
        } while (!Objects.equals(command, QUIT.getMessage()));
    }

    public void setBridge() {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        System.out.println(bridge);
    }

    public void playGame() {
        for (int i = 0; i < bridgeSize; i++) {
            staticView.askMoveMsg();
            String readMoving = inputView.readMoving();

            PassFail result = bridgeGame.move(readMoving, i);
            outputView.printMap(result, readMoving, i);
            if (result == PassFail.FAIL) break;
        }
    }
}




