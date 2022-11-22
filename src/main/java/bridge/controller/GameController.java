package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.CheckException;
import bridge.view.GameSign;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.ViewMessage;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    /* 상수 및 클래스 변수 */
    private final int GAME_TRY_NUMBER = 1;
    private final int GAME_SUCCESS_OR_FAIL_NUMBER = 0;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<String> bridge;
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();
    private final List<String> resultGame = new ArrayList<>();
    private final CheckException checkException = new CheckException();

    /* 인스턴스 변수 */
    private String bridgeSize = "";
    private int stage = 0;
    private int tryNumber = 1;
    private String moving = "";

    private String retryChoice = "";

    public void init() {
        outputView.printGameStart();
        System.out.println();
        makeBridgeForGame();
    }

    public void makeBridgeForGame() {
        while (true) {
            bridgeSize = inputView.readBridgeSize();
            if (!checkException.checkBridgeSize(bridgeSize)) {
                continue;
            }
            System.out.println();
            bridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
            break;
        }
    }

    public void addBridgeMove(String direction) {
        if (direction.equals(GameSign.UP_MOVING.getMessage())) {
            addUpMove(bridgeGame.move(bridge, direction, stage));
            return;
        }
        addDownMove(bridgeGame.move(bridge, direction, stage));
    }

    public void addUpMove(String move) {
        if (move.equals(GameSign.MOVING_SUCCESS.getMessage())) {
            upBridge.add(GameSign.MOVING_SUCCESS.getMessage());
            downBridge.add(GameSign.MOVING_NOT.getMessage());
            return;
        }
        upBridge.add(GameSign.MOVING_FAIL.getMessage());
        downBridge.add(GameSign.MOVING_NOT.getMessage());
    }

    public void addDownMove(String move) {
        if (move.equals(GameSign.MOVING_SUCCESS.getMessage())) {
            downBridge.add(GameSign.MOVING_SUCCESS.getMessage());
            upBridge.add(GameSign.MOVING_NOT.getMessage());
            return;
        }
        downBridge.add(GameSign.MOVING_FAIL.getMessage());
        upBridge.add(GameSign.MOVING_NOT.getMessage());
    }

    public void runGame() {
        moveInGame();
        outputView.printMap(upBridge, downBridge);
        System.out.println();
    }

    public void moveInGame() {
        stage++;
        while (true) {
            moving = inputView.readMoving();
            if (!checkException.checkInputMoving(moving)) {
                continue;
            }
            addBridgeMove(moving);
            break;
        }
    }

    public boolean checkFail(int stage) {
        return upBridge.get(stage - 1).equals(GameSign.MOVING_FAIL.getMessage()) ||
                downBridge.get(stage - 1).equals(GameSign.MOVING_FAIL.getMessage());
    }

    public void startGame() {
        while (stage < Integer.parseInt(bridgeSize)) {
            runGame();
            if (checkFail(stage)) {
                if (!retryChoice()) {
                    return;
                }
                clearGame();
            }
        }
        addFinishGameResult();
    }

    public void clearGame() {
        stage = 0;
        tryNumber++;
        upBridge.clear();
        downBridge.clear();
    }

    public boolean retryChoice() {
        while (true) {
            retryChoice = inputView.readGameCommand();
            if (!checkException.checkInputRetryChoice(retryChoice)) {
                continue;
            }
            return quitRetry(retryChoice);
        }
    }


    public boolean quitRetry(String retryChoice) {
        if (!bridgeGame.retry(retryChoice)) {
            resultGame.add(ViewMessage.RESULT_GAME_FAIL_MESSAGE.getMessage());
            resultGame.add((String.valueOf(tryNumber)));
            return false;
        }
        return true;
    }

    public void addFinishGameResult() {
        resultGame.add(ViewMessage.RESULT_GAME_SUCCESS_MESSAGE.getMessage());
        resultGame.add((String.valueOf(tryNumber)));
    }

    public void endGame() {
        System.out.println(ViewMessage.RESULT_GAME_MESSAGE.getMessage());
        outputView.printMap(upBridge, downBridge);
        System.out.println();
        outputView.printResult(resultGame.get(GAME_SUCCESS_OR_FAIL_NUMBER), resultGame.get(GAME_TRY_NUMBER));
    }
}
