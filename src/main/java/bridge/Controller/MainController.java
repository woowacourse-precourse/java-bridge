package bridge.Controller;

import bridge.Enum.GameStatus;
import bridge.Model.BridgeGame;
import bridge.Model.VO.BridgeSize;
import bridge.Model.VO.UserChoice;
import bridge.Model.VO.UserCommand;
import bridge.View.InputView;
import bridge.View.OutputView;

public class MainController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void initGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeSize bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public void run(){
        GameStatus gameStatus = GameStatus.RUNNING;
        while(gameStatus.equals(GameStatus.RUNNING)) {
            UserChoice userChoice = inputView.readMoving();
            bridgeGame.move(userChoice);
            gameStatus = bridgeGame.checkGameStatus();
            outputView.printMap(bridgeGame.getUserChoices(), bridgeGame.getCrossResults());

            if (gameStatus.equals(GameStatus.FAIL)) {
                UserCommand userCommand = inputView.readGameCommand();
                if (userCommand.isQuit()) {
                    //pass
                } else if (userCommand.isRetry()) {
                    bridgeGame.retry();
                    gameStatus = GameStatus.RUNNING;
                }
            }
        }
        outputView.printResult(bridgeGame.getUserChoices(), bridgeGame.getCrossResults(), gameStatus, bridgeGame.getTryCount());
    }
}
