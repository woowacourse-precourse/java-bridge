package controller;

import model.BridgeGame;
import view.InputView;
import view.OutputStatic;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class PlayGame {
    private List<String> crossAble;
    private int endTurn;
    private int turn = 0;
    private int tryCount = 1;

    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    public PlayGame(List<String> crossAble, int endTurn) {
        this.crossAble = crossAble;
        this.endTurn = endTurn;
    }

    public void playGame() {
        while (turn < endTurn) {
            Boolean isRetry = playerMove();
            if (isRetry) {
                continue;
            }
            endTurn = turn + 1;
            break;
        }
        printResult();
    }

    private Boolean playerMove() {
        String move = inputView.setMoving();
        Boolean matchResult = bridgeGame.move(crossAble, turn, move);
        if (matchResult) {
            turn++;
            return true;
        }
        String gameCommand = inputView.setGameCommand();
        Boolean isRetry = bridgeGame.retry(gameCommand);
        tryCount++;
        return isRetry;
    }

    private void printResult() {
        List<HashMap> bridge = List.of(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
        System.out.println(OutputStatic.END_GAME_TITLE.getOutputPrint());
        outputView.printMap(endTurn, bridge);
        outputView.printResult(endTurn, bridge, tryCount);
    }
}
