package bridge;

import java.util.List;

public class BridgeGameManager {
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private List<String> bridge;
    String gameResult = "실패";
    int gameTryCount = 0;

   public BridgeGameManager(BridgeMaker bridgeMaker, BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
       this.bridgeMaker = bridgeMaker;
       this.bridgeGame = bridgeGame;
       this.inputView = inputView;
       this.outputView = outputView;
   }

    public void start() {
        outputView.printStart();

        int bridgeSize = inputView.readBridgeSize();;

        bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);             // TODO: 지워야됨

        tryGame(bridgeSize);

        outputView.printResult(gameResult, gameTryCount);
    }

    private void tryGame(int bridgeSize) {
        String command = "R";

        while (command.equals("R")) {
            bridgeGame.retry();
            gameTryCount += 1;
            String moveResult = tryMove(bridgeSize);

            command = judgeSuccessOrReadCommand(moveResult);
        }
    }

    private String tryMove(int bridgeSize) {
        String movingResult = " O ";
        int bridgeIndex = 0;

        while (movingResult.equals(" O ") && bridgeIndex < bridgeSize) {
            String moving = inputView.readMoving();
            movingResult = bridgeGame.move(bridge, moving, bridgeIndex);
            outputView.printMap();
            bridgeIndex += 1;
        }
        return movingResult;
    }

    private String judgeSuccessOrReadCommand(String moveResult) {
        if (moveResult.equals(" O ")) {
            gameResult = "성공";
            return "Q";
        }

        return inputView.readGameCommand();
    }
}
