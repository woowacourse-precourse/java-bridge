package bridge.view;

import bridge.model.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private BridgeGame bridgeGame;
    private BridgeException bridgeException;
    private GameStatistics gameStatistics;
    private OutputView outputView;

    public InputView(BridgeGame bridgeGame, BridgeException bridgeException, GameStatistics gameStatistics, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.bridgeException = bridgeException;
        this.gameStatistics = gameStatistics;
        this.outputView = outputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public void readBridgeSize() {
        System.out.println(MessageView.PLAY_BRIDGE_GAME.getMessage());
        System.out.println(MessageView.INPUT_BRIDGE_LENGTH.getMessage());
        String bridgeLength = Console.readLine();
        bridgeException.invalidLengthInputValue(bridgeLength);
        bridgeGame.getBridge().setSize(Integer.parseInt(bridgeLength));
        this.gameStatistics.setAnswerRoad(bridgeGame.getBridgeMaker().makeBridge(Integer.parseInt(bridgeLength)));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void readMoving() {
        while (true) {
            System.out.println(MessageView.SELECT_TO_MOVE.getMessage());
            String moveDirection = Console.readLine();
            bridgeException.invalidMovingInputValue(moveDirection);
            gameStatistics.getCheckRoad().add(bridgeGame.move(moveDirection, gameStatistics.getAnswerRoad(), bridgeGame.getPlayer()));
            //
            System.out.println(gameStatistics.getCheckRoad());
            //
            boolean roundResult = bridgeGame.constructBridge();
            outputView.printMap();
            if (!roundResult) {
                String retryGame = readGameCommand();
                if (retryGame.equals("Q")) {
                    break;
                } else if (retryGame.equals("R")) {
                    gameStatistics.increaseTotalTryCount();
                    bridgeGame.backUpBridge();
                    bridgeGame.getPlayer().initCurrentLocation();
                    gameStatistics.initCheckRoad();
                }
            } else if (Player.currentLocation == bridgeGame.getBridge().getSize()) {
                gameStatistics.setGameResult("성공");
                System.out.println();
                outputView.printResult();
                break;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(MessageView.INPUT_RETRY_OR_NOT_GAME.getMessage());
        String retryGame = Console.readLine();
        bridgeException.invalidRetryGame(retryGame);
        if (retryGame.equals("Q")) {
            gameStatistics.setGameResult("실패");
            outputView.printResult();
        } return retryGame;
    }
}
