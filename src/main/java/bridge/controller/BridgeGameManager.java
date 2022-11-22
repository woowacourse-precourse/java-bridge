package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.model.Command;
import bridge.domain.model.GameResult;
import bridge.domain.model.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameManager {
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private List<String> bridge;
    private String gameResult = GameResult.LOSE.getResult();
    private int gameTryCount = 0;

    public BridgeGameManager(BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
       this.bridgeMaker = bridgeMaker;
       this.bridgeGame = bridgeGame;
       this.inputView = new InputView();
       this.outputView = new OutputView(bridgeGame);
    }

    public void start() {
        outputView.printStart();

        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);

        tryGame(bridgeSize);

        outputView.printResult(gameResult, gameTryCount);
    }

    private void tryGame(int bridgeSize) {
        String command = Command.RETRY.getSymbol();

        while (command.equals(Command.RETRY.getSymbol())) {
            bridgeGame.retry();
            gameTryCount += 1;
            String moveResult = tryMove(bridgeSize);

            command = judgeSuccessOrReadCommand(moveResult);
        }
    }

    private String tryMove(int bridgeSize) {
        String movingResult = MoveResult.SUCCESS.getSymbol();
        int bridgeIndex = 0;

        while (movingResult.equals(MoveResult.SUCCESS.getSymbol()) && bridgeIndex < bridgeSize) {
            String moving = inputView.readMoving();
            movingResult = bridgeGame.move(bridge, moving, bridgeIndex);
            outputView.printMap();
            bridgeIndex += 1;
        }
        return movingResult;
    }

    private String judgeSuccessOrReadCommand(String moveResult) {
        if (moveResult.equals(MoveResult.SUCCESS.getSymbol())) {
            gameResult = GameResult.WIN.getResult();
            return Command.QUIT.getSymbol();
        }

        return inputView.readGameCommand();
    }
}
