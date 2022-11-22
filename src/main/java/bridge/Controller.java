package bridge;

import bridge.game.BridgeGame;
import bridge.game.BridgeMaker;
import bridge.game.BridgeNumberGenerator;
import bridge.game.BridgeRandomNumberGenerator;
import bridge.status.GameResult;
import bridge.status.PassOrNot;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.StaticView;

import java.util.List;
import java.util.Objects;

import static bridge.status.GameResult.*;
import static bridge.status.PassOrNot.*;
import static bridge.status.RetryOrQuit.*;
import static bridge.view.InputView.*;


public class Controller {
    BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(generator);
    InputView inputView = new InputView();
    BridgeGame bridgeGame;
    OutputView outputView = new OutputView();
    StaticView staticView = new StaticView();

    GameResult gameResult;

    public void run() {
        setBridge();
        gameController();
    }

    public void setBridge() {
        staticView.gameStartMsg();
        inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        System.out.println(bridge); //
    }

    public void gameController() {
        String command = null;

        while (noQuitNoSuccess(command)) {
            playGame();
            command = noPassAskRetry(command);
            choseToRetry(command);
        }
        choseToQuit(command);
    }

    private boolean noQuitNoSuccess(String command) {
        return !Objects.equals(command, QUIT.getMessage()) && gameResult != SUCCESS;
    }

    private String noPassAskRetry(String command) {
        if (gameResult != SUCCESS) {
            command = inputView.readGameCommand();
        }
        return command;
    }

    private void choseToRetry(String command) {
        if (Objects.equals(command, RETRY.getMessage())) {
            bridgeGame.retry();
        }
    }

    private void choseToQuit(String command) {
        if (Objects.equals(command, QUIT.getMessage())) {
            gameResult = FAIL;
            staticView.gameResultMsg();
            outputView.printResult();
            staticView.successOrFailMsg(gameResult.getValue());
            staticView.tryNumMsg(BridgeGame.tryNum);
        }
    }

    private void playGame() {

        for (int i = 0; i < bridgeSize; i++) {

            PassOrNot result = moveAndPrintMap(i);

            if (result == NO_PASS) break;

            gameSuccess(i, result);
        }
    }

    private void gameSuccess(int i, PassOrNot result) {
        if (result == PASS && i == bridgeSize - 1) { // [종료 - 성공]
            gameResult = SUCCESS;
            staticView.gameResultMsg();
            outputView.printResult();
            staticView.successOrFailMsg(gameResult.getValue());
            staticView.tryNumMsg(BridgeGame.tryNum);
        }
    }

    private PassOrNot moveAndPrintMap(int i) {
        String readMoving = inputView.readMoving();

        PassOrNot result = bridgeGame.move(readMoving, i);
        outputView.printMap(result, readMoving, i);
        return result;
    }
}




