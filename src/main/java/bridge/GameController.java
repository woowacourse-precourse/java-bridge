package bridge;

import static bridge.Util.convertStringToInt;
import static bridge.Validation.*;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public GameController(OutputView outputView, InputView inputView, BridgeMaker bridgeMaker) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void manageGame(BridgeGame bridgeGame, Bridge bridge) {
        int tryCount = 1;
        while (true) {
            if (!restartGame(startGame(bridgeGame, bridge), bridgeGame)) {
                endGame(bridgeGame, bridge, tryCount);
                break;
            }
            tryCount++;
        }
    }

    public int createBridgeSize() {
        try {
            return getBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBridgeSize();
        }
    }

    public int getBridgeSize() {
        String bridgeSize = inputView.readBridgeSize();
        isPositiveInteger(bridgeSize);
        isInRange(convertStringToInt(bridgeSize));
        return convertStringToInt(bridgeSize);
    }

    public void readyForGame() {
        outputView.printStartGame();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(createBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame();
        manageGame(bridgeGame, bridge);
    }

    public void activateUserTurn(BridgeGame bridgeGame, Bridge bridge) {
        while(true) {
            String userSelect = getMoveCommand();
            bridgeGame.move(userSelect);
            outputView.printMap(bridge.getBridge(), bridgeGame.getUserPath());
            if(!bridge.moveCheck(userSelect, bridgeGame) || bridgeGame.checkGameClear(bridge)) {
                break;
            }
        }
    }

    public String getMoveCommand() {
        String userSelect = inputView.readMoving();
        Validation.validateMoveTo(userSelect);
        return userSelect;
    }

    public boolean startGame(BridgeGame bridgeGame, Bridge bridge) {
        try {
            activateUserTurn(bridgeGame, bridge);
            return bridgeGame.checkGameClear(bridge);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return startGame(bridgeGame, bridge);
        }
    }

    public boolean restartGame(boolean clear, BridgeGame bridgeGame) {
        if (clear) { // 게임 클리어면 종료
            return false;
        }
        return checkRestart(bridgeGame); // 게임 실패, 재시작이면 계속하기, 종료이면 종료
    }
    public boolean checkRestart(BridgeGame bridgeGame) {
        try {
            return getRestartCommand(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkRestart(bridgeGame);
        }
    }

    public boolean getRestartCommand(BridgeGame bridgeGame) {
        String command = inputView.readGameCommand();
        Validation.validateRestart(command);
        if (command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    public void endGame(BridgeGame bridgeGame, Bridge bridge, int tryCount) {
        outputView.printMapResult(bridge.getBridge(), bridgeGame.getUserPath());
        outputView.printGameResult(bridgeGame.checkGameClear(bridge));
        outputView.printTotalTry(tryCount);
    }

}