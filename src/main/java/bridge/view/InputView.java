package bridge.view;

import bridge.model.*;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private BridgeException bridgeException;
    private GameStatistics gameStatistics;
    private OutputView outputView;
    private Bridge bridge;
    private BridgeGame bridgeGame;

    public InputView(BridgeGame bridgeGame, BridgeException bridgeException, OutputView outputView) {
        this.bridge = bridgeGame.getBridge();
        this.bridgeException = bridgeException;
        this.gameStatistics = bridgeGame.getGameStatistics();
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        boolean isOccurException;
        do {
            String bridgeLength = enterBridgeSize();
            isOccurException = checkExceptionOccur(true, bridgeLength);
        } while (isOccurException);
    }

    private boolean checkExceptionOccur(boolean isOccurException, String bridgeLength) {
        try {
            System.out.println();
            isOccurException = bridgeException.invalidLengthInputValue(bridgeLength);
            settingBridgeValues(bridgeLength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isOccurException;
    }

    private String enterBridgeSize() {
        String bridgeLength;
        System.out.println(MessageView.INPUT_BRIDGE_LENGTH.getMessage());
        bridgeLength = Console.readLine();
        return bridgeLength;
    }

    private void settingBridgeValues(String bridgeLength) {
        bridge.setSize(Integer.parseInt(bridgeLength));
        this.gameStatistics.setAnswerRoad(bridge.getBridgeMaker().makeBridge(Integer.parseInt(bridgeLength)));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving() {
        while (true) {
            gameStatistics.getCheckRoad().add(bridgeGame.move(enterMoveDirection(), gameStatistics.getAnswerRoad(), bridgeGame.getPlayer()));
            boolean roundResult = bridge.buildBridge();
            outputView.printMap();
            if (isGameFinished(roundResult)) break;
        }
    }

    private String enterMoveDirection() {
        String moveDirection = null;
        boolean b = true;
        do {
            System.out.println(MessageView.SELECT_TO_MOVE.getMessage());
            try {
                moveDirection = Console.readLine();
                b = bridgeException.invalidMovingInputValue(moveDirection);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (b);
        return moveDirection;
    }

    private boolean isGameFinished(boolean roundResult) {
        if (!roundResult) {
            String retryGame = readGameCommand();
            return checkRetryCommand(retryGame);
        } else if (Player.currentLocation == bridge.getSize()) {
            showGameResult();
            return true;
        }
        return false;
    }

    private void showGameResult() {
        gameStatistics.setGameResult(MessageView.RETURN_SUCCESS.getMessage());
        outputView.printResult();
    }

    private boolean checkRetryCommand(String retryGame) {
        if (retryGame.equals(MessageView.RETURN_QUIT.getMessage())) {
            return true;
        }
        bridgeGame.retry();
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryGame;
        retryGame = operateGameCommand();
        if (retryGame.equals(MessageView.RETURN_QUIT.getMessage())) {
            gameStatistics.setGameResult(MessageView.RETURN_FAIL.getMessage());
            outputView.printResult();
        }
        return retryGame;
    }

    private String operateGameCommand() {
        boolean b = true;
        return enterGameCommand(null, b);
    }

    private String enterGameCommand(String retryGame, boolean b) {
        do {
            System.out.println(MessageView.INPUT_RETRY_OR_NOT_GAME.getMessage());
            try {
                retryGame = Console.readLine();
                b = bridgeException.invalidRetryGame(retryGame);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (b);
        return retryGame;
    }

    public OutputView getOutputView() {
        return outputView;
    }
}
