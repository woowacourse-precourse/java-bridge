package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputValidator.BridgeSize;
import bridge.InputValidator.CommandInput;
import bridge.UserStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    InputView inputView;
    OutputView outputView;
    List<String> bridge;
    UserStatus userStatus;
    BridgeGame bridgeGame;


    public GameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void StartGame() {
        storeBridge();
        setUserStatus();
        System.out.println(bridge);
    }

    public boolean playEachGame() {
        if(bridgeGame.isGameFinished(bridge, userStatus.getUserLocation())){
            return quitGame();
        }
        String input = inputView.readMoving();
        if (!bridgeGame.move(bridge, userStatus.getUserLocation(), input)) {
            return askUserRestart();
        }
        userStatus.addUserLocation();
        outputView.printMap(bridge, userStatus.getUserLocation());
        return playEachGame();
    }

    private void storeBridge() {
        String bridgeSizeInput = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(bridgeSizeInput);
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
    }

    private boolean askUserRestart() {
        outputView.printFailedMap(bridge, userStatus.getUserLocation());
        String input = inputView.readGameCommand();
        if (bridgeGame.retry(input)) {
            return restartGame();
        }
        return quitGame();
    }

    private boolean restartGame() {
        userStatus.addUserAttempt();
        userStatus.resetUserLocation();
        return true;
    }

    private boolean quitGame() {
        outputView.printResult();
        return false;
    }

    private void setUserStatus() {
        this.userStatus = new UserStatus(this.bridge);
    }
}
