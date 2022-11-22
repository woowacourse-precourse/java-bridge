package bridge.controller;

import static bridge.Bridge.createBridge;
import static bridge.Cross.CAN_CROSS;
import static bridge.Cross.CAN_NOT_CROSS;
import static bridge.constant.message.OutputMessage.FAILURE;
import static bridge.constant.message.OutputMessage.SUCCESS;
import static bridge.controller.InputController.getGameCommand;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.Cross;
import bridge.GameCommand;
import bridge.Map;
import bridge.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private static int attempts = 1;
    private String success;
    private static GameCommand gameCommand = GameCommand.RETRY;
    private Map map;

    public GameController() {
        outputView = new OutputView();
        success = FAILURE.getMessage();
    }

    public void start() {
        outputView.printStartOfGame();

        proceed();

        outputView.printFinalMessage(success, attempts);
    }

    private void proceed() {
        Bridge bridge = createBridge();

        repeatEachRound(bridge);
    }

    private void repeatEachRound(Bridge bridge) {
        while (continueGame()) {
            BridgeGame bridgeGame = initBridgeGame(bridge);
            int finalIndex = bridgeGame.move();
            Cross cross = bridgeGame.getCross();
            if (successOrFailure(bridgeGame, finalIndex, cross)) {
                break;
            }
        }
    }

    public boolean continueGame() {
        return isQuit() || isFailure();
    }

    private boolean isQuit() {
        return gameCommand == GameCommand.QUIT;
    }

    private boolean isFailure() {
        return success.equals(FAILURE.getMessage());
    }

    private BridgeGame initBridgeGame(Bridge bridge) {
        map = createMap();

        return createBridgeGame(bridge);
    }

    private Map createMap() {
        return new Map();
    }

    private BridgeGame createBridgeGame(Bridge bridge) {
        return new BridgeGame(bridge, map);
    }

    private boolean successOrFailure(BridgeGame bridgeGame, int finalIndex, Cross cross) {
        isSuccess(bridgeGame.getBridge(), finalIndex, cross);

        return isFailure(bridgeGame, cross);
    }

    private void isSuccess(Bridge bridge, int finalIndex, Cross cross) {
        if (bridge.isEndOfBridge(finalIndex) && cross == CAN_CROSS) {
            success = SUCCESS.getMessage();
            outputView.printResult(map);
        }
    }

    private boolean isFailure(BridgeGame bridgeGame, Cross cross) {
        if (canNotCross(cross)) {
            setGameCommand(getGameCommand(), bridgeGame);
            if (isQuit()) {
                outputView.printResult(map);
                return true;
            }
        }
        return false;
    }

    private boolean canNotCross(Cross cross) {
        return cross == CAN_NOT_CROSS;
    }

    private void setGameCommand(GameCommand userCommand, BridgeGame bridgeGame) {
        bridgeGame.retry(userCommand);
    }

    public static void addAttempt() {
        attempts++;
    }

    public static void setRetry() {
        gameCommand = GameCommand.RETRY;
    }

    public static void setQuit() {
        gameCommand = GameCommand.QUIT;
    }
}
