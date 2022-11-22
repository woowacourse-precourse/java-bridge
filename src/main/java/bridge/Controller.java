package bridge;

import java.util.List;

public class Controller {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = BridgeGame.getInstance();
    String bridgeSize;
    String command;
    String restartCommand;
    int bridgeCount;
    int gameCount = 1;


    public void run() {
        List<String> bridge = bridgeGameInit();
        System.out.println(bridge);
        bridgeGameStart(bridge);
    }

    private void bridgeGameStart(List<String> bridge) {
        boolean reStart = false;
        do {
            crossBridge(bridge);
            reStart = isRestart(reStart);
            gameCount++;
        }while(reStart);
    }

    private boolean isRestart(boolean reStart) {
        if(bridgeGame.isClear(bridgeSize)) {
            reStart = false;
        }
        if(bridgeGame.isPlayerDead()) {
            tryInputRestartOrQuit();
        }
        return reStart;
    }

    private void crossBridge(List<String> bridge) {
        boolean playerDead = true;
        do {
            tryInputBridgeUpOrDown();
            bridgeGame.move(command, bridge, bridgeCount++);
            outputView.printMap();
        } while (!bridgeGame.isPlayerDead() && !bridgeGame.isClear(bridgeSize));
    }

    private List<String> bridgeGameInit() {
        outputView.printGameStart();
        bridgeGame.initMap();
        bridgeCount = 0;
        tryInputBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        return bridge;
    }

    private void tryInputBridgeUpOrDown() {
        do {
            outputView.printInputUpOrDown();
            command = inputView.readMoving();
        } while (validateUpOrDown(command));
    }

    private void tryInputBridgeSize() {
        do {
            outputView.printInputBridgeSize();
            bridgeSize = inputView.readBridgeSize();
        } while (validateNumberAndRange(bridgeSize));
    }

    private void tryInputRestartOrQuit() {
        do {
            outputView.printInputRestartOrQuit();
            restartCommand = inputView.readGameCommand();
        } while (validateRestartOrQuit(restartCommand));
    }

    private boolean validateRestartOrQuit(String restartCommand) {
        try {
            isRorQ(restartCommand);
        }catch(IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return true;
        }
        return false;
    }

    private void isRorQ(String restartCommand) {
        if(!restartCommand.equals("R") && !restartCommand.equals("Q")) {
            throw Exceptions.R_OR_Q_EXCEPTION.getException();
        }
    }

    private boolean validateUpOrDown(String command) {
        try {
            isUpOrDown(command);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return true;
        }
        return false;
    }

    private void isUpOrDown(String command) {
        if (!command.equals("U") && !command.equals("D")) {
            throw Exceptions.U_OR_D_EXCEPTION.getException();
        }
    }

    private boolean validateNumberAndRange(String bridgeSize) {
        try {
            validateNumber(bridgeSize);
            validateRange(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return true;
        }
        return false;
    }

    private void validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw Exceptions.NOT_NUMBER_EXCEPTION.getException();
        }
    }

    private void validateRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);

        if (number < 3 || number > 20) {
            throw Exceptions.OUT_OF_RANGE_EXCEPTION.getException();
        }
    }
}