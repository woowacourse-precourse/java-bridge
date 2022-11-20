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

    public InputView(Bridge bridge, BridgeGame bridgeGame, BridgeException bridgeException,
                     GameStatistics gameStatistics, OutputView outputView) {
        this.bridge = bridge;
        this.bridgeException = bridgeException;
        this.gameStatistics = gameStatistics;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        String bridgeLength;
        do {
            System.out.println(MessageView.PLAY_BRIDGE_GAME.getMessage() + "\n");
            System.out.println(MessageView.INPUT_BRIDGE_LENGTH.getMessage());
            bridgeLength = Console.readLine();
        } while(bridgeException.invalidLengthInputValue(bridgeLength));
        bridge.setSize(Integer.parseInt(bridgeLength));
        this.gameStatistics.setAnswerRoad(bridge.getBridgeMaker().makeBridge(Integer.parseInt(bridgeLength)));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving() {
        while (true) {
            String moveDirection;
            do {
                System.out.println(MessageView.SELECT_TO_MOVE.getMessage());
                moveDirection = Console.readLine();
            } while(bridgeException.invalidMovingInputValue(moveDirection));
            gameStatistics.getCheckRoad().add(bridgeGame.move(moveDirection, gameStatistics.getAnswerRoad(), bridgeGame.getPlayer()));
            boolean roundResult = bridge.buildBridge();
            outputView.printMap();
            if (isGameFinished(roundResult)) break;
        }
    }

    private boolean isGameFinished(boolean roundResult) {
        if (!roundResult) {
            String retryGame = readGameCommand();
            if (checkRetryCommand(retryGame)) return true;
        } else if (Player.currentLocation == bridge.getSize()) {
            showGameResult();
            return true;
        }
        return false;
    }

    private void showGameResult() {
        gameStatistics.setGameResult("성공");
        System.out.println();
        outputView.printResult();
    }

    private boolean checkRetryCommand(String retryGame) {
        if (retryGame.equals("Q")) {
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
        do {
            System.out.println(MessageView.INPUT_RETRY_OR_NOT_GAME.getMessage());
            retryGame = Console.readLine();
        } while(bridgeException.invalidRetryGame(retryGame));
        if (retryGame.equals("Q")) {
            gameStatistics.setGameResult("실패");
            outputView.printResult();
        } return retryGame;
    }
}
