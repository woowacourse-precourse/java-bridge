package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.UserMovement;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;

public class GameRun {
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();


    public static int gameRun(Bridge bridge, int retryCnt) {
        do {
            bridgeGame.retry();
            retryCnt++;
            while (repeatUserMovement(bridge)) {
                userMove();
                outputView.printMap(new ArrayList<>(), new ArrayList<>());
            }
        } while (gameContinue());
        return retryCnt;
    }

    private static void userMove() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean repeatUserMovement(Bridge bridge) {
        return Judgement.judgeUserMovement(bridge.compareWithUserMovement(UserMovement.getUserMovement()))
                && !bridge.atTheEndOfBridge(UserMovement.getUserMovement());
    }

    private static boolean gameContinue() {
        return inputView.readGameCommand().equals("R");
    }
}
