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


    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void StartGame() {
        storeBridge();
        setUserStatus();
        System.out.println(bridge);
        userStatus.addUserAttempt();
    }

    public boolean playEachGame() {
        if (checkGameFinished()) {
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

    private boolean checkGameFinished() {
        if (bridgeGame.isGameFinished(bridge, userStatus.getUserLocation())) {
            userStatus.setGameResultSuccess();
            return true;
        }
        return false;
    }

    private void storeBridge() {
        String bridgeSizeInput = inputView.readBridgeSize();
        try{
            BridgeSize bridgeSize = new BridgeSize(bridgeSizeInput);
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
        } catch (Exception e){
            System.out.println("[ERROR] 다리 길이에 유효한 숫자가 들어가야 합니다.");
            storeBridge();
        }
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
        outputView.printResult(bridge, userStatus);
        return false;
    }


    private void setUserStatus() {
        this.userStatus = new UserStatus(this.bridge);
    }
}
