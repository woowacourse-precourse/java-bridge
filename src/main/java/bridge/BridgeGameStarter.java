package bridge;

import bridge.view.utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameStarter {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;

    public BridgeGameStarter(BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public void start() {
        List<String> bridge = bridgeMaker.makeBridge(inputBridgeSize());
        int tryCount = 0;
        while (true) {
            tryCount++;
            Bridge userBridge = new Bridge(new ArrayList<>(), new ArrayList<>());
            PlayerStatus playerStatus = moveBridge(bridge, userBridge);
            if(isFinishCondition(tryCount, userBridge, playerStatus)) {
                return;
            }
        }
    }

    public PlayerStatus moveBridge(List<String> bridge, Bridge userBridge) {
        PlayerStatus playerStatus = new PlayerStatus();

        for (String currentDirection : bridge) {
            playerStatus = move(userBridge, playerStatus, currentDirection);
            if (!playerStatus.isMatch()) {
                break;
            }
        }
        return playerStatus;
    }

    private PlayerStatus move(Bridge userBridge, PlayerStatus playerStatus, String currentDirection) {
        playerStatus = isMatchWithBridge(currentDirection);
        bridgeGame.move(userBridge, playerStatus);
        ConsoleUtils.printBridge(userBridge);

        return playerStatus;
    }

    private PlayerStatus isMatchWithBridge(String currentDirection) {
        String nextDirection = inputmoving();

        if (currentDirection.equals(nextDirection)) {
            return new PlayerStatus(nextDirection, true);
        }

        return new PlayerStatus(nextDirection, false);
    }

    public boolean isFinishCondition(int tryCount, Bridge userBridge, PlayerStatus playerStatus) {
        return finishWithWin(tryCount, userBridge, playerStatus) || finishWithLose(tryCount, userBridge, playerStatus);
    }

    private boolean finishWithWin(int tryCount, Bridge userBridge, PlayerStatus playerStatus) {
        if (playerStatus.isMatch()) {
            ConsoleUtils.printGameResult(userBridge, tryCount, playerStatus);
            return true;
        }
        return false;
    }

    private boolean finishWithLose(int tryCount, Bridge userBridge, PlayerStatus playerStatus) {
        String gameCommand = inputGameCommand();

        if (bridgeGame.retry(gameCommand)) {
            ConsoleUtils.printGameResult(userBridge, tryCount, playerStatus);
            return true;
        }
        return false;
    }

    private static int inputBridgeSize() {
        try {
            return ConsoleUtils.inputBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static String inputmoving() {
        try {
            return ConsoleUtils.inputMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputmoving();
        }
    }

    private static String inputGameCommand() {
        try {
            return ConsoleUtils.inputGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommand();
        }
    }
}