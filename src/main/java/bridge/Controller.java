package bridge;

import bridge.game.BridgeGame;
import bridge.game.BridgeMaker;
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

    private void gameController() {
        String command = null;

        while (noQuitNoSuccess(command)) {
            playGame();
//            ====================================== 재시작 관련 로직
            command = noPassAskRetry(command);
            choseToRetry(command);
        }
//        =====================================================
        // Q 입력시 로직 [종료 - 실패]
        choseToQuit(command);
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

    private void choseToRetry(String command) {
        if (Objects.equals(command, RETRY.getMessage())) { // R 입력시 로직
            bridgeGame.retry();
        }
    }

    private String noPassAskRetry(String command) {
        if (gameResult != SUCCESS) { //다리건너기 실패시 실행되는 로직
            command = inputView.readGameCommand();
        }
        return command;
    }

    public void setBridge() {
        staticView.gameStartMsg();
        inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
        System.out.println(bridge);
    }

    private boolean noQuitNoSuccess(String command) {
        return !Objects.equals(command, QUIT.getMessage()) && gameResult != SUCCESS;
    }

    public void playGame() {

        for (int i = 0; i < bridgeSize; i++) {

            PassOrNot result = moveAndPrintMap(i);

            if (result == NO_PASS) break;

            gameSuccess(i, result);
        }
    }

    private void gameSuccess(int i, PassOrNot result) {
        if (result == PASS && i == bridgeSize -1) { // [종료 - 성공]
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




