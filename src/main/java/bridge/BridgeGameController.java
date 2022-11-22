package bridge;

import bridge.Constant.GameCommand;

public class BridgeGameController {
    private GameHelper gameHelper;

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        setGame();
        processGame();
        winGame();
    }

    private void setGame() {
        try {
            int size = getBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            gameHelper = new GameHelper(new BridgeGame(bridgeMaker.makeBridge(size)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setGame();
        }
    }

    private int getBridgeSize() {
        int size = InputValidation.convertToInt(InputView.readBridgeSize());
        InputValidation.validateBridgeSize(size);
        return size;
    }

    public void processGame() {
        while (gameHelper.selectRightBlock() && !gameHelper.reachEnd()) {
            move();
            OutputView.printMap(gameHelper.getBridge(), gameHelper.getResultBridge());
        }
        if (!gameHelper.reachEnd())
            retry();
    }

    private void move() {
        try {
            String upOrDown = getMoving();
            gameHelper.initGame(upOrDown);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            move();
        }
    }

    private static String getMoving() {
        String moving = InputView.readMoving();
        InputValidation.validateUpDown(moving);
        return moving;
    }

    private void winGame() {
        OutputView.printResult(gameHelper, gameHelper.getTrialCount());
    }

    private void retry() {
        try {
            String command = getGameCommand();
            if (command.equals(GameCommand.RETRY.get())) retryGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry();
        }
    }

    private void retryGame() {
        gameHelper.restart();
        processGame();
    }

    private static String getGameCommand() {
        String command = InputView.readGameCommand();
        InputValidation.validateCommand(command);
        return command;
    }
}